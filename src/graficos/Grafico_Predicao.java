package graficos;

/**
 *
 * @author Luiz
 */
import java.awt.Color;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Grafico_Predicao extends ApplicationFrame {

    final private TimeSeriesCollection collection1 = new TimeSeriesCollection();
    final private TimeSeriesCollection collection2 = new TimeSeriesCollection();
    final private TimeSeriesCollection collection3 = new TimeSeriesCollection();

    final private TimeSeries tensaoBomba = new TimeSeries("Tensão da Bomba", Millisecond.class);
    final private TimeSeries nivelT1 = new TimeSeries("Nível T1", Millisecond.class);
    final private TimeSeries predT1 = new TimeSeries("Predição Nível T1", Millisecond.class);
    final private TimeSeries erroPredicao = new TimeSeries("Erro de Predição", Millisecond.class);

    final private Color cinza1 = new Color(215, 215, 215);

    public Grafico_Predicao(final String title, int x, int y) {
        super(title);

        final CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new DateAxis("Tempo (hh:mm:ss)"));
        final JFreeChart chart = new JFreeChart(title, plot);

        // Adicionando cada sinal em suas coleções
        collection1.addSeries(tensaoBomba);
        collection2.addSeries(nivelT1);
        collection2.addSeries(predT1);
        collection3.addSeries(erroPredicao);

        // Collection 1
        NumberAxis rangeAxis1 = new NumberAxis("Tensão (V)");
        rangeAxis1.setAutoRangeIncludesZero(false);
        rangeAxis1.setRange(0.0, 7.0);
        XYPlot subplot = new XYPlot(collection1, null, rangeAxis1, new StandardXYItemRenderer());
        subplot.setBackgroundPaint(cinza1);
        subplot.setDomainGridlinePaint(Color.BLACK);
        subplot.setRangeGridlinePaint(Color.BLACK);
        plot.add(subplot);

        // Collection 2
        NumberAxis rangeAxis2 = new NumberAxis("Nível (cm)");
        rangeAxis2.setAutoRangeIncludesZero(false);
        rangeAxis2.setRange(0.0, 30.0);
        XYPlot subplot2 = new XYPlot(collection2, null, rangeAxis2, new StandardXYItemRenderer());
        subplot2.setBackgroundPaint(cinza1);
        subplot2.setDomainGridlinePaint(Color.BLACK);
        subplot2.setRangeGridlinePaint(Color.BLACK);
        plot.add(subplot2);

        // Collection 3
        NumberAxis rangeAxis3 = new NumberAxis("Nível (cm)");
        rangeAxis3.setAutoRangeIncludesZero(false);
        rangeAxis3.setRange(-3.0, 3.0);
        XYPlot subplot3 = new XYPlot(collection3, null, rangeAxis3, new StandardXYItemRenderer());
        subplot3.setBackgroundPaint(cinza1);
        subplot3.setDomainGridlinePaint(Color.BLACK);
        subplot3.setRangeGridlinePaint(Color.BLACK);
        plot.add(subplot3);

        final ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(120000.0);  // 120 seconds

        final ChartPanel chartPanel = new ChartPanel(chart, true, true, true, false, true);
        chartPanel.setPreferredSize(new java.awt.Dimension(x, y));
        setContentPane(chartPanel);
    }

    public void addValores() {
        double p1 = 0 + (7 - 0) * Math.random();
        double p2 = 0 + (30 - 0) * Math.random();
        double p3 = -3 + (3 - (-3)) * Math.random();

        collection1.getSeries(0).add(new Millisecond(), p1);
        collection2.getSeries(0).add(new Millisecond(), p2);
        collection2.getSeries(1).add(new Millisecond(), p2 * 0.5);
        collection3.getSeries(0).add(new Millisecond(), p3);
    }

    public static void main(final String[] args) {
        final Grafico_Predicao demo = new Grafico_Predicao("Dynamic Data Demo 3", 1020, 600);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
