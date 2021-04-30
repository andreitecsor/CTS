package tecsor.andrei.g1087.composite;

import java.util.ArrayList;
import java.util.List;

public class Challenge extends StructureNode {
    private String name;
    private List<StructureNode> nodes = new ArrayList<>();

    public Challenge(String name) {
        this.name = name;
    }

    @Override
    public Integer getCondition() {
        int totalWeeksCondition = 0;
        for (StructureNode node : nodes) {
            totalWeeksCondition += node.getCondition();
        }
        return totalWeeksCondition;
    }

    @Override
    public void complete() {
        for (StructureNode node : nodes) {
            node.complete();
        }
        this.isDone = true;
    }

    @Override
    public boolean isCompleted() {
        for (StructureNode node : nodes) {
            if (!node.isCompleted()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addNode(StructureNode node) {
        this.nodes.add(node);
    }

    @Override
    public void deleteNode(StructureNode node) {
        this.nodes.remove(node);
    }

    @Override
    public StructureNode getNode(int index) {
        return this.nodes.get(index);
    }
}
