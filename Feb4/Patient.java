class Patient{
        static String hospitalName;
        String name;
        int age;
        String ailment;
        static int totalPatient=0;
	int patientId;
        Patient(String name, int age, String ailment, final int patientId){
                this.name=name;
                this.age=age;
                this.ailment=ailment;
		this.patientId=patientId;
                totalPatient++;
        }
        public static void getTotalPatients(){
                System.out.println("Total number of Patients are:"+totalPatient);
        }
        public static void main(String args[]){
                Patient object=new Patient("Raj",46,"Fracture",2312);
                new Patient("Rashmika",65,"Knee Injury",2344);
                if(object instanceof Patient){
                        System.out.println("Object is an instance of Patient class");
                }
                else{
                        System.out.println("Object is not an instance of Patient class");
                }
                Patient.getTotalPatients();
        }
}
