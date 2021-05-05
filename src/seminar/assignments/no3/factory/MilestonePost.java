package seminar.assignments.no3.factory;

public class MilestonePost extends Post {
    private String newNoOfWeeksRecord;

    public MilestonePost(Type type, String newRecord) {
        super(type);
        this.newNoOfWeeksRecord = newRecord;
    }

    @Override
    public void showPost() {
        System.out.println(this.getCreatedAt() + " - User broke his own record! New record: " + newNoOfWeeksRecord);
    }
}
