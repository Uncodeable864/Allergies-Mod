package net.kidkoder.allergies.capability.allergies;

import java.util.concurrent.Callable;

        public class AllergiesFactory implements Callable<IAllergies> {

            @Override
            public IAllergies call() throws Exception {
                CapabilityAllergies capabilityAllergies = new CapabilityAllergies();
        return capabilityAllergies;
    }
}
