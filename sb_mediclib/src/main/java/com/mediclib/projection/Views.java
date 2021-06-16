package com.mediclib.projection;

public interface Views {
    public static interface Common { }

    public static interface Patient extends Common { }
    public static interface PatientExtended extends Patient { }
    public static interface PatientmedCondtion extends PatientExtended { }

    public static interface Address extends Common { }
    public static interface AddressComplete extends Address { }

    public static interface Doctor extends Common { }
    public static interface DoctorComplete extends Doctor { }
    public static interface DoctorMedSpeciality extends DoctorComplete, MedSpe { }

    public static interface MedCond extends Common { }

    public static interface MedSpe extends Common { }
    public static interface MedSpeComplete extends MedSpe { }
    public static interface MedSpeDoctor extends MedSpeComplete,Doctor { }

    public static interface Appointment extends Common { }
//    public static interface SickPatient extends Common { }
}
