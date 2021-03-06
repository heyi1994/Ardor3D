/**
 * Copyright (c) 2008-2018 Ardor Labs, Inc.
 *
 * This file is part of Ardor3D.
 *
 * Ardor3D is free software: you can redistribute it and/or modify it
 * under the terms of its license which may be found in the accompanying
 * LICENSE file or at <http://www.ardor3d.com/LICENSE>.
 */

package com.ardor3d.tool.editor.particle.swing.panel;

import java.awt.BorderLayout;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ardor3d.extension.effect.particle.SimpleParticleInfluenceFactory;
import com.ardor3d.tool.editor.swing.widget.ValuePanel;

public class DragInfluencePanel extends InfluenceEditPanel {

    private static final long serialVersionUID = 1L;

    private final ValuePanel _dragCoefficientPanel = new ValuePanel("Drag Coefficient: ", "", 0.0, Double.MAX_VALUE,
            0.1);

    public DragInfluencePanel() {
        super();
        setLayout(new BorderLayout());

        _dragCoefficientPanel.setBorder(createTitledBorder(" DRAG PARAMETERS "));
        _dragCoefficientPanel.addChangeListener(new ChangeListener() {
            public void stateChanged(final ChangeEvent e) {
                ((SimpleParticleInfluenceFactory.BasicDrag) getEdittedInfluence())
                .setDragCoefficient(_dragCoefficientPanel.getFloatValue());
            }
        });
        add(_dragCoefficientPanel, BorderLayout.CENTER);
    }

    @Override
    public void updateWidgets() {
        _dragCoefficientPanel.setValue(((SimpleParticleInfluenceFactory.BasicDrag) getEdittedInfluence())
                .getDragCoefficient());
    }

}
