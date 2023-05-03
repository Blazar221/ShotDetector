package tool;

import model.IndexNode;

import java.util.ArrayList;
import java.util.List;

public enum ProcessTool {
    INSTANCE;

    /**
     * Create mock index hierarchy nodes for test use
     *
     * @return A tree of indexNodes, with root->scene->shot->subshot structure
     */
    public List<IndexNode> getMockIndexNodes() {
        List<IndexNode> nodes = new ArrayList<>();
        IndexNode scene1 = new IndexNode("Scene1", 0.0);
        IndexNode shot11 = new IndexNode("Shot1", 0.0);
        IndexNode shot12 = new IndexNode("Shot2", 3.0);
        scene1.addChildren(shot11);
        scene1.addChildren(shot12);
        IndexNode scene2 = new IndexNode("Scene2", 5.0);
        IndexNode shot21 = new IndexNode("Shot1",5.0);
        IndexNode shot22 = new IndexNode("Shot2",8.0);
        IndexNode subshot221 = new IndexNode("Subshot1",8.0);
        IndexNode subshot222 = new IndexNode("Subshot2",50.0);
        scene2.addChildren(shot21);
        scene2.addChildren(shot22);
        shot22.addChildren(subshot221);
        shot22.addChildren(subshot222);

        nodes.add(scene1);
        nodes.add(scene2);
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        nodes.add(new IndexNode("Scene x", 20.0));
        return nodes;
    }
}
