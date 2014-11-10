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

public class Grafico_Correcao extends ApplicationFrame {

    final private TimeSeriesCollection collection1 = new TimeSeriesCollection();
    final private TimeSeriesCollection collection2 = new TimeSeriesCollection();
    private final Render render = new Render();
    final private TimeSeries falhasFiltradas = new TimeSeries("Falhas Filtradas", Millisecond.class);
    final private TimeSeries nivelCorrigido = new TimeSeries("Sinal do Nível do Tanque Corrigido", Millisecond.class);
    final private TimeSeries sinalComFalhas = new TimeSeries("Sinal com Falhas (Nível T1)", Millisecond.class);

    public Grafico_Correcao(final String title, int x, int y) {
        super(title);

        final CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new DateAxis("Tempo (hh:mm:ss)"));
        final JFreeChart chart = new JFreeChart(title, plot);

        // Adicionando cada sinal em suas coleções
        collection1.addSeries(falhasFiltradas);
        collection2.addSeries(nivelCorrigido);
        collection2.addSeries(sinalComFalhas);

        // Collection 1
        NumberAxis rangeAxis1 = new NumberAxis("Nível (cm)");
        rangeAxis1.setAutoRangeIncludesZero(false);
        rangeAxis1.setRange(-30.0, 30.0);
        XYPlot subplot = new XYPlot(collection1, null, rangeAxis1, new StandardXYItemRenderer());
        subplot.setBackgroundPaint(Color.WHITE);
        subplot.setDomainGridlinePaint(Color.BLACK);
        subplot.setRangeGridlinePaint(Color.BLACK);
        render.Render(subplot, Color.MAGENTA);
        plot.add(subplot);

        // Collection 2
        NumberAxis rangeAxis2 = new NumberAxis("Nível (cm)");
        rangeAxis2.setAutoRangeIncludesZero(false);
        rangeAxis2.setRange(0.0, 30.0);
        XYPlot subplot2 = new XYPlot(collection2, null, rangeAxis2, new StandardXYItemRenderer());
        subplot2.setBackgroundPaint(Color.WHITE);
        subplot2.setDomainGridlinePaint(Color.BLACK);
        subplot2.setRangeGridlinePaint(Color.BLACK);
        render.Render(subplot2, render.verde1, Color.BLUE);
        plot.add(subplot2);

        final ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(120000.0);  // 120 seconds

        final ChartPanel chartPanel = new ChartPanel(chart, true, true, true, false, true);
        chartPanel.setPreferredSize(new java.awt.Dimension(x, y));
        setContentPane(chartPanel);
    }

    public void addValoresRand() {
        double p1 = -30 + (30 - (-30)) * Math.random();
        double p2 = 0 + (7 - 0) * Math.random();

        collection1.getSeries(0).add(new Millisecond(), p1);
        collection2.getSeries(0).add(new Millisecond(), p2);
        collection2.getSeries(1).add(new Millisecond(), p2 * 0.5);
    }

    public void addValores(double falhasFiltradas, double sinalCorrigido, double sinalComFalhas) {
        Millisecond time = new Millisecond();
        collection1.getSeries(0).add(time, falhasFiltradas);
        collection2.getSeries(0).add(time, sinalCorrigido);
        collection2.getSeries(1).add(time, sinalComFalhas);
    }

    public static void main(final String[] args) {
        final Grafico_Correcao demo = new Grafico_Correcao("Dynamic Data Demo 3", 1020, 600);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}
