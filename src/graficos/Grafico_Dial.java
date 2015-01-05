package graficos;

/**
 *
 * @author Luiz
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Point;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.DialBackground;
import org.jfree.chart.plot.dial.DialCap;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialPointer;
import org.jfree.chart.plot.dial.DialTextAnnotation;
import org.jfree.chart.plot.dial.DialValueIndicator;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialRange;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

public class Grafico_Dial extends ApplicationFrame implements ChangeListener {

    DefaultValueDataset dataset = new DefaultValueDataset(0.0D);

    public Grafico_Dial(final String title, int x, int y) {
        super(title);
        JFreeChart localJFreeChart = createStandardDialChart("Bomba", "Tensão (V)", this.dataset, 0.0D, 7.0D, 1.0D, 3);
        DialPlot localDialPlot = (DialPlot) localJFreeChart.getPlot();

        StandardDialRange localStandardDialRange1 = new StandardDialRange(5.0D, 7.0D, Color.red);
        localStandardDialRange1.setInnerRadius(0.52D);
        localStandardDialRange1.setOuterRadius(0.55D);
        localDialPlot.addLayer(localStandardDialRange1);

        StandardDialRange localStandardDialRange2 = new StandardDialRange(1.0D, 5.0D, Color.green);
        localStandardDialRange2.setInnerRadius(0.52D);
        localStandardDialRange2.setOuterRadius(0.55D);
        localDialPlot.addLayer(localStandardDialRange2);

        StandardDialRange localStandardDialRange3 = new StandardDialRange(0.0D, 1.0D, Color.yellow);
        localStandardDialRange3.setInnerRadius(0.52D);
        localStandardDialRange3.setOuterRadius(0.55D);
        localDialPlot.addLayer(localStandardDialRange3);

        GradientPaint localGradientPaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(), new Color(170, 170, 220));
        DialBackground localDialBackground = new DialBackground(localGradientPaint);
        localDialBackground.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
        localDialPlot.setBackground(localDialBackground);
        localDialPlot.removePointer(0);

        DialPointer.Pointer localPointer = new DialPointer.Pointer();
        localDialPlot.addPointer(localPointer);

        ChartPanel localChartPanel = new ChartPanel(localJFreeChart);
        localChartPanel.setPreferredSize(new Dimension(x, y));
        add(localChartPanel);
    }

    public static void main(final String[] args) {
        //Controle_Grafico_Dial localDialDemo1 = new Controle_Grafico_Dial("JFreeChart: DialDemo1.java");
        Grafico_Dial localDialDemo1 = new Grafico_Dial("Teste", 640, 480);

        localDialDemo1.pack();
        localDialDemo1.setVisible(true);
    }

    public static JFreeChart createStandardDialChart(String paramString1, String paramString2, ValueDataset paramValueDataset, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt) {
        DialPlot localDialPlot = new DialPlot();
        localDialPlot.setDataset(paramValueDataset);
        localDialPlot.setDialFrame(new StandardDialFrame());
        localDialPlot.setBackground(new DialBackground());
        DialTextAnnotation localDialTextAnnotation = new DialTextAnnotation(paramString2);
        localDialTextAnnotation.setFont(new Font("Dialog", 1, 14));
        localDialTextAnnotation.setRadius(0.7D);
        localDialPlot.addLayer(localDialTextAnnotation);
        DialValueIndicator localDialValueIndicator = new DialValueIndicator(0);
        localDialPlot.addLayer(localDialValueIndicator);
        StandardDialScale localStandardDialScale = new StandardDialScale(paramDouble1, paramDouble2, -120.0D, -300.0D, 10.0D, 4);
        localStandardDialScale.setMajorTickIncrement(paramDouble3);
        localStandardDialScale.setMinorTickCount(paramInt);
        localStandardDialScale.setTickRadius(0.88D);
        localStandardDialScale.setTickLabelOffset(0.15D);
        localStandardDialScale.setTickLabelFont(new Font("Dialog", 0, 14));
        localDialPlot.addScale(0, localStandardDialScale);
        localDialPlot.addPointer(new DialPointer.Pin());
        DialCap localDialCap = new DialCap();
        localDialPlot.setCap(localDialCap);
        return new JFreeChart(paramString1, localDialPlot);
    }

    public void setValorDial(double x) {
        this.dataset.setValue(x);
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
