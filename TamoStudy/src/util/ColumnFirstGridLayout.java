package util;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class ColumnFirstGridLayout implements LayoutManager {
    private int rows;
    private int cols;

    public ColumnFirstGridLayout(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {}

    @Override
    public void removeLayoutComponent(Component comp) {}

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return calculateLayoutSize(parent);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return calculateLayoutSize(parent);
    }

    @Override
    public void layoutContainer(Container parent) {
        int componentCount = parent.getComponentCount();
        int x = 0;
        int y = 0;
        int width = parent.getWidth() / cols;
        int height = parent.getHeight() / rows;

        for (int i = 0; i < componentCount; i++) {
            Component component = parent.getComponent(i);
            component.setBounds(x, y, width, height);
            x += width;

            if (x >= parent.getWidth()) {
                x = 0;
                y += height;
            }
        }
    }

    private Dimension calculateLayoutSize(Container parent) {
        int componentCount = parent.getComponentCount();
        int width = parent.getWidth() / cols;
        int height = parent.getHeight() / rows;

        int rows = Math.min(this.rows, (componentCount + cols - 1) / cols);
        int cols = Math.min(this.cols, (componentCount + rows - 1) / rows);

        return new Dimension(width * cols, height * rows);
    }
}

