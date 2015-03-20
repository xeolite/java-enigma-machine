package com.github.xeolite.enigma.step;

import com.github.xeolite.enigma.rotor.Rotor;

public enum Step {

    ZERO {
        @Override
        public void engage(Rotor rotor) {
        }

        @Override
        public Step pairedWith(Step other) {
            return other;
        }

    },
    ONE {
         @Override
         public void engage(Rotor rotor) {
             rotor.step();
         }

        @Override
        public Step pairedWith(Step other) {
            return this;
        }

    };

    public abstract void engage(Rotor rotor);

    public abstract Step pairedWith(Step other);

}
