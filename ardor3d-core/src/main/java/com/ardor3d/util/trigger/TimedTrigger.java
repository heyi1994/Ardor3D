/**
 * Copyright (c) 2008-2018 Ardor Labs, Inc.
 *
 * This file is part of Ardor3D.
 *
 * Ardor3D is free software: you can redistribute it and/or modify it
 * under the terms of its license which may be found in the accompanying
 * LICENSE file or at <http://www.ardor3d.com/LICENSE>.
 */

package com.ardor3d.util.trigger;

import com.ardor3d.util.Timer;

public class TimedTrigger extends AbstractArmableTrigger {

    protected Timer _timer = new Timer();
    protected double _triggerTime;

    public void arm(final double triggerSeconds) {
        _state = State.Armed;
        _timer.reset();
        _triggerTime = triggerSeconds;
    }

    @Override
    public void checkTrigger() {
        if (_state == State.Armed && _timer.getTimeInSeconds() >= _triggerTime) {
            trigger();
        }
    }

}
