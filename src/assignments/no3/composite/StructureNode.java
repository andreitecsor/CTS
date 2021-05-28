package assignments.no3.composite;


public abstract class StructureNode implements Doable {
    protected boolean isDone;

    public abstract void addNode(StructureNode node);

    public abstract void deleteNode(StructureNode node);

    public abstract StructureNode getNode(int index);
}
