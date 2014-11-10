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

public class Grafico_Diagnostico extends ApplicationFrame {

    final private TimeSeriesCollection collection1 = new TimeSeriesCollection();
    final private TimeSeriesCollection collection2 = new TimeSeriesCollection();
    final private TimeSeriesCollection collection3 = new TimeSeriesCollection();
    private final Render render = new Render();
    final private TimeSeries nivelT1 = new TimeSeries("Nível T1", Millisecond.class);
    final private TimeSeries predT1 = new TimeSeries("Predição Nível T1", Millisecond.class);
    final private TimeSeries sinalReal = new TimeSeries("Entrada Fuzzy: Sinal Real", Millisecond.class);
    final private TimeSeries sinalEstimado = new TimeSeries("Entrada Fuzzy: Sinal Estimado", Millisecond.class);
    final private TimeSeries tipoFalha = new TimeSeries("Saída Fuzzy: Tipo de Falha", Millisecond.class);


    public Grafico_Diagnostico(final String title, int x, int y) {
        super(title);

        final CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new DateAxis("Tempo (hh:mm:ss)"));
        final JFreeChart chart = new JFreeChart(title, plot);

        // Adicionando cada sinal em suas coleções
        collection1.addSeries(nivelT1);
        collection1.addSeries(predT1);
        collection2.addSeries(sinalReal);
        collection2.addSeries(sinalEstimado);
        collection3.addSeries(tipoFalha);

        // Collection 1
        NumberAxis rangeAxis1 = new NumberAxis("Nível (cm)");
        rangeAxis1.setAutoRangeIncludesZero(false);
        rangeAxis1.setRange(0.0, 30.0);
        XYPlot subplot = new XYPlot(collection1, null, rangeAxis1, new StandardXYItemRenderer());
        subplot.setBackgroundPaint(Color.WHITE);
        subplot.setDomainGridlinePaint(Color.BLACK);
        subplot.setRangeGridlinePaint(Color.BLACK);
        render.Render(subplot, Color.BLUE, Color.red);
        plot.add(subplot);

        // Collection 2
        NumberAxis rangeAxis2 = new NumberAxis("∆Nível (cm)");
        rangeAxis2.setAutoRangeIncludesZero(false);
        //rangeAxis2.setRange(-30.0, 30.0);
        XYPlot subplot2 = new XYPlot(collection2, null, rangeAxis2, new StandardXYItemRenderer());
        subplot2.setBackgroundPaint(Color.WHITE);
        subplot2.setDomainGridlinePaint(Color.BLACK);
        subplot2.setRangeGridlinePaint(Color.BLACK);
        render.Render(subplot2, render.verde1, render.amarelo1);
        plot.add(subplot2);

        // Collection 3
        NumberAxis rangeAxis3 = new NumberAxis("Tipo de Falha");
        rangeAxis3.setAutoRangeIncludesZero(false);
        rangeAxis3.setRange(1.0, 4.0);
        XYPlot subplot3 = new XYPlot(collection3, null, rangeAxis3, new StandardXYItemRenderer());
        subplot3.setBackgroundPaint(Color.WHITE);
        subplot3.setDomainGridlinePaint(Color.BLACK);
        subplot3.setRangeGridlinePaint(Color.BLACK);
        render.Render(subplot3, Color.BLACK);
        plot.add(subplot3);

        final ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(120000.0);  // 120 seconds

        final ChartPanel chartPanel = new ChartPanel(chart, true, true, true, false, true);
        chartPanel.setPreferredSize(new java.awt.Dimension(x, y));
        setContentPane(chartPanel);
    }

    public void addValoresRand() {
        double p1 = 0 + (30 - 0) * Math.random();
        double p2 = -30 + (30 - (-30)) * Math.random();
        double p3 = 1 + (4 - 1) * Math.random();

        collection1.getSeries(0).add(new Millisecond(), p1);
        collection1.getSeries(1).add(new Millisecond(), p1 * 0.6);
        collection2.getSeries(0).add(new Millisecond(), p2);
        collection2.getSeries(1).add(new Millisecond(), p2 * 0.4);
        collection3.getSeries(0).add(new Millisecond(), p3);
    }

    public void addValores(double nivelT1, double predT1, double sinalReal, double sinalEstimado, double tipoFalha) {
        Millisecond time = new Millisecond();
        collection1.getSeries(0).addOrUpdate(time, nivelT1);
        collection1.getSeries(1).addOrUpdate(time, predT1);
        collection2.getSeries(0).addOrUpdate(time, sinalReal);
        collection2.getSeries(1).addOrUpdate(time, sinalEstimado);
        collection3.getSeries(0).addOrUpdate(time, tipoFalha);
    }

    public static void main(final String[] args) {
        final Grafico_Diagnostico demo = new Grafico_Diagnostico("Dynamic Data Demo 3", 1020, 600);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
