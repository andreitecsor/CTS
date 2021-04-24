package tecsor.andrei.g1087;

import tecsor.andrei.g1087.factory.FactoryPost;
import tecsor.andrei.g1087.factory.Post;
import tecsor.andrei.g1087.factory.Type;
import tecsor.andrei.g1087.singleton.Neo4JConnection;

public class TestAssignment {
    public static void main(String[] args) {
        //SINGLETON
        System.out.println("==============SINGLETON==============");
        Neo4JConnection connection = Neo4JConnection.getInstance();
        Neo4JConnection connection2 = Neo4JConnection.getInstance();
        System.out.println(connection);
        System.out.println(connection2);
        if (connection.equals(connection2)) {
            System.out.println("Singleton");
        }
        System.out.println();


        //FACTORY
        System.out.println("==============FACTORY==============");
        Post post = FactoryPost.getPostType(Type.AWARD, "The walker - 1 month of no using the car");
        post.showPost();
        post = FactoryPost.getPostType(Type.CHALLENGE, "Selective collection");
        post.showPost();
        post = FactoryPost.getPostType(Type.FOLLOW, "Andrei");
        post.showPost();
        post = FactoryPost.getPostType(Type.MILESTONE, "24 weeks");
        post.showPost();


    }
}
