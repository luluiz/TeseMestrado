package graficos;

import java.awt.BasicStroke;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class Controle_Grafico extends ApplicationFrame {

    XYSeries series1 = new XYSeries("Nível T1");
    XYSeries series2 = new XYSeries("Tensão Bomba");
    XYSeries series3 = new XYSeries("Predição do Nível T1");
    XYSeries series4 = new XYSeries("Diagnóstico de Falhas");
    XYSeries series5 = new XYSeries("Nível Corrigido");
    XYSeries series6 = new XYSeries("Filtro das Falhas");
    XYSeries series7 = new XYSeries("Erro de Predição");

    List<XYSeries> listaSeries = new ArrayList<XYSeries>(18);

    final XYSeriesCollection collection = new XYSeriesCollection();
    final XYSeriesCollection collection2 = new XYSeriesCollection();
    final XYSeriesCollection collection3 = new XYSeriesCollection();

    public Controle_Grafico(final String title, int x, int y) {
        super(title);

        listaSeries.add(series1);
        listaSeries.add(series2);
        listaSeries.add(series3);
        listaSeries.add(series4);
        listaSeries.add(series5);
        listaSeries.add(series6);
        listaSeries.add(series7);

        //NIVEL e SetPoints
        collection.addSeries(series1); //nivelt1
        collection.addSeries(series2); //setPoint
        collection.addSeries(series3);//nivel t2

        //acoes
        collection2.addSeries(series4);//erro

        //sinais de controle
        collection2.addSeries(series5);//tensao pid1
        collection2.addSeries(series6);//tensao pid2
        collection2.addSeries(series7);//tensao pid3

        final JFreeChart chart = createCombinedChart();
        final ChartPanel chartPanel = new ChartPanel(chart, true, true, true, false, true);
        chartPanel.setPreferredSize(new java.awt.Dimension(x, y));
        setContentPane(chartPanel);
    }

    private JFreeChart createCombinedChart() {
        // create subplot 1...
        final XYDataset data1 = collection;
        final XYItemRenderer renderer1 = new StandardXYItemRenderer();
        renderer1.setSeriesStroke(0, new BasicStroke(1.5f));
        renderer1.setSeriesStroke(1, new BasicStroke(1.5f));
        renderer1.setSeriesStroke(2, new BasicStroke(1.5f));
        renderer1.setSeriesStroke(3, new BasicStroke(1.5f));
        final NumberAxis rangeAxis1 = new NumberAxis("Nivel (cm)");
        final XYPlot subplot1 = new XYPlot(data1, null, rangeAxis1, renderer1);
        subplot1.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);

        /*
         final XYTextAnnotation annotation = new XYTextAnnotation("Hello!", 50.0, 10000.0);
         annotation.setFont(new Font("SansSerif", Font.PLAIN, 9));
         annotation.setRotationAngle(Math.PI / 4.0);
         subplot1.addAnnotation(annotation);
         */
        // create subplot 2...
        final XYDataset data2 = collection2;
        final XYItemRenderer renderer2 = new StandardXYItemRenderer();
        final NumberAxis rangeAxis2 = new NumberAxis("Ações");
        final XYPlot subplot2 = new XYPlot(data2, null, rangeAxis2, renderer2);
        renderer2.setSeriesStroke(0, new BasicStroke(1.5f));
        renderer2.setSeriesStroke(1, new BasicStroke(1.5f));
        renderer2.setSeriesStroke(2, new BasicStroke(1.5f));
        renderer2.setSeriesStroke(3, new BasicStroke(1.5f));
        subplot2.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);

        // create subplot 3...
        final XYDataset data3 = collection3;
        final XYItemRenderer renderer3 = new StandardXYItemRenderer();
        final NumberAxis rangeAxis3 = new NumberAxis("Sinais de Controle");
        renderer3.setSeriesStroke(0, new BasicStroke(1.5f));
        renderer3.setSeriesStroke(1, new BasicStroke(1.5f));
        final XYPlot subplot3 = new XYPlot(data3, null, rangeAxis3, renderer3);
        subplot3.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);

        // parent plot...
        final NumberAxis tempoAxis = new NumberAxis("Tempo");
        final CombinedDomainXYPlot plot = new CombinedDomainXYPlot(tempoAxis);
        //plot.setRangeMinorGridlineStroke(new BasicStroke(5.0f));
        //plot.setDomainGridlineStroke(new BasicStroke(5.0f));

        plot.setGap(10.0);

        // add the subplots...
        plot.add(subplot1, 1);
        plot.add(subplot2, 1);
        plot.add(subplot3, 1);
        plot.setOrientation(PlotOrientation.VERTICAL);

        // return a new chart containing the overlaid plot...
        JFreeChart chart = new JFreeChart("", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        return chart;

    }

    public void adicionarValores(double tempo, double nivelT1, double nivelT2, double setPoint, double erro, double tesao_pid1,
            double tesao_pid2, double tesao_pid3, double acaoControle) {
        series1.add(tempo, nivelT1);
        series2.add(tempo, nivelT2);
        series3.add(tempo, setPoint);
        series4.add(tempo, erro);
        series5.add(tempo, tesao_pid1);
        series6.add(tempo, tesao_pid2);
        series7.add(tempo, tesao_pid3);
    }

    public void addValoresTeste(double tempo, double k) {
        series1.add(tempo, k);
    }

    public void atualizarSeries(List<Boolean> lista) {
        collection.removeAllSeries();
        collection2.removeAllSeries();
        collection3.removeAllSeries();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i)) {
                if (i < 3) {
                    collection.addSeries(listaSeries.get(i));
                }
                if ((i >= 3 && i < 4)) {
                    collection2.addSeries(listaSeries.get(i));
                }
                if ((i >= 4) && (i <= 7)) {
                    collection3.addSeries(listaSeries.get(i));
                }
            }
        }
    }

    public static void main(final String[] args) {
        final Controle_Grafico demo = new Controle_Grafico("Gráficos", 800, 600);
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }

}
