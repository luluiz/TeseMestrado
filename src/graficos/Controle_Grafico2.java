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

public class Controle_Grafico2 extends ApplicationFrame {

    final private TimeSeriesCollection collection1 = new TimeSeriesCollection();
    final private TimeSeriesCollection collection2 = new TimeSeriesCollection();
    final private TimeSeriesCollection collection3 = new TimeSeriesCollection();

    final private TimeSeries nivelT1 = new TimeSeries("Nível T1", Millisecond.class);
    final private TimeSeries predT1 = new TimeSeries("Predição Nível T1", Millisecond.class);
    final private TimeSeries diagFalhas = new TimeSeries("Diagnóstico de Falhas", Millisecond.class);
    final private TimeSeries tensaoBomba = new TimeSeries("Tensão da Bomba", Millisecond.class);
    final private TimeSeries nivelCorrigido = new TimeSeries("Nível Corrigido", Millisecond.class);

    public Controle_Grafico2(final String title, int x, int y) {
        super(title);

        final CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new DateAxis("Tempo (hh:mm:ss)"));
        final JFreeChart chart = new JFreeChart(title, plot);

        collection1.addSeries(nivelT1);
        collection1.addSeries(predT1);
        collection2.addSeries(diagFalhas);
        collection2.addSeries(tensaoBomba);
        collection3.addSeries(nivelCorrigido);

        NumberAxis rangeAxis = new NumberAxis("Y 1");
        rangeAxis.setAutoRangeIncludesZero(false);
        XYPlot subplot = new XYPlot(collection1, null, rangeAxis, new StandardXYItemRenderer());
        subplot.setBackgroundPaint(new Color(220, 220, 220));
        plot.add(subplot);

        NumberAxis rangeAxis2 = new NumberAxis("Y 2");
        rangeAxis2.setAutoRangeIncludesZero(false);
        XYPlot subplot2 = new XYPlot(collection2, null, rangeAxis2, new StandardXYItemRenderer());
        subplot2.setBackgroundPaint(new Color(225, 225, 225));
        plot.add(subplot2);

        NumberAxis rangeAxis3 = new NumberAxis("Y 3");
        rangeAxis3.setAutoRangeIncludesZero(false);
        XYPlot subplot3 = new XYPlot(collection3, null, rangeAxis3, new StandardXYItemRenderer());
        subplot3.setBackgroundPaint(new Color(220, 220, 220));
        plot.add(subplot3);

        final ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(120000.0);  // 120 seconds

        final ChartPanel chartPanel = new ChartPanel(chart, true, true, true, false, true);
        chartPanel.setPreferredSize(new java.awt.Dimension(x, y));
        setContentPane(chartPanel);
    }

    public void addValores() {
        collection1.getSeries(0).add(new Millisecond(), 0.90 + 0.2 * Math.random());
        collection1.getSeries(1).add(new Millisecond(), 0.90 + 0.2 * Math.random());
        collection2.getSeries(0).add(new Millisecond(), 0.90 + 0.2 * Math.random());
        collection2.getSeries(1).add(new Millisecond(), 0.90 + 0.2 * Math.random());
        collection3.getSeries(0).add(new Millisecond(), 0.90 + 0.2 * Math.random());
    }

    public static void main(final String[] args) {
        final Controle_Grafico2 demo = new Controle_Grafico2("Dynamic Data Demo 3", 1020, 600);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
