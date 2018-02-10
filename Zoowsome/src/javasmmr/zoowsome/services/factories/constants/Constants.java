package javasmmr.zoowsome.services.factories.constants;

public final class Constants {

    public static final class Species {
        public static final String Mammals = "Mammals";
        public static final String Reptiles="Reptiles";
        public static final String Birds="Birds";
        public static final String Aquatics="Aquatics";
        public static final String Insects="Insects";
    }

    public static final class Animals{
        public static final class Mammals{
            public static final String Cow="COW";
            public static final String Monkey="MONKEY";
            public static final String Tiger="TIGER";
        }

        public static final class Reptiles{
            public static final String Aligator="ALIGATOR";
            public static final String Snake="SNAKE";
            public static final String Crocodile="CROCODILE";
        }

        public static final class Birds{
            public static final String Owl="OWL";
            public static final String Colibri="COLIBRI";
            public static final String Parrot="PARROT";
        }

        public static final class Aquatics{
            public static final String Medusa="MEDUSA";
            public static final String Rac="RAC";
            public static final String Whale="WHALE";
        }

        public static final class Insects{
            public static final String Butterfly="BUTTERFLY";
            public static final String Spider="SPIDER";
            public static final String Cockroach="COOKROACH";
        }
    }

    public static final class XML_TAGS{
        public static final String DISCRIMINANT="DISCRIMINANT";
        public static final String ANIMAL="ANIMAL";
        public static final String EMPLOYEE="EMPLOYEE";
    }

    public static final class EmployeeType{
        public static final String Caretakers="CARETAKERS";
    }
    public static final class FactoryTyes{
        public static final String CaretakersFactory="CARETAKERSFACTORY";
    }
    public static final class Caretakers{
        public static final String TCO_SUCCESS="SUCCESS";
        public static final String TCO_KILLED="KILLED";
        public static final String TCO_NO_TIME="NO_TIME";
    }

    public static final class Frames{
        public static final int WIDTH=700;
        public static final int HEIGHT=500;
    }
}
