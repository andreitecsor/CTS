package assignments.no3.composite;

public class Stage extends StructureNode {
    private String task;
    private Integer condition;

    public Stage(String task, Integer condition) {
        this.task = task;
        this.condition = condition;
    }

    @Override
    public Integer getCondition() {
        return this.condition;
    }

    @Override
    public void complete() {
        this.isDone = true;
    }

    @Override
    public boolean isCompleted() {
        return this.isDone;
    }

    @Override
    public void addNode(StructureNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteNode(StructureNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public StructureNode getNode(int index) {
        throw new UnsupportedOperationException();
    }
}
