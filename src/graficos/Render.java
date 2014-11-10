package graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;

/**
 *
 * @author Veyron-PC
 */
public class Render {

    final public Color cinza1 = new Color(215, 215, 215);
    final public Color verde1 = new Color(34, 139, 34);
    final public Color amarelo1 = new Color(255, 215, 0);

    public Render() {
    }

    public void Render(XYPlot plot, Color l1) {
        final XYItemRenderer renderer = plot.getRenderer();

        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer itemRenderer = (StandardXYItemRenderer) renderer;
            itemRenderer.setSeriesStroke(0, new BasicStroke(1.5f));

            itemRenderer.setSeriesPaint(0, l1);
        }
    }

    public void Render(XYPlot plot, Color l1, Color l2) {
        final XYItemRenderer renderer = plot.getRenderer();

        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer itemRenderer = (StandardXYItemRenderer) renderer;
            itemRenderer.setSeriesStroke(0, new BasicStroke(1.5f));
            itemRenderer.setSeriesStroke(1, new BasicStroke(1.5f));

            itemRenderer.setSeriesPaint(0, l1);
            itemRenderer.setSeriesPaint(1, l2);
        }
    }

    public void Render(XYPlot plot, Color l1, Color l2, Color l3) {
        final XYItemRenderer renderer = plot.getRenderer();

        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer itemRenderer = (StandardXYItemRenderer) renderer;
            itemRenderer.setSeriesStroke(0, new BasicStroke(1.5f));
            itemRenderer.setSeriesStroke(1, new BasicStroke(1.5f));
            itemRenderer.setSeriesStroke(2, new BasicStroke(1.5f));

            itemRenderer.setSeriesPaint(0, l1);
            itemRenderer.setSeriesPaint(1, l2);
            itemRenderer.setSeriesPaint(2, l3);

        }

    }

}
