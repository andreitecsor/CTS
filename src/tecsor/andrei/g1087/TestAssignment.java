package tecsor.andrei.g1087;

import tecsor.andrei.g1087.builder.*;
import tecsor.andrei.g1087.factory.FactoryPost;
import tecsor.andrei.g1087.factory.Post;
import tecsor.andrei.g1087.factory.Type;
import tecsor.andrei.g1087.singleton.Neo4JConnection;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TestAssignment {
    public static void main(String[] args) {
        //region SINGLETON
        System.out.println("==============SINGLETON==============");
        Neo4JConnection connection = Neo4JConnection.getInstance();
        Neo4JConnection connection2 = Neo4JConnection.getInstance();
        System.out.println(connection);
        System.out.println(connection2);
        if (connection.equals(connection2)) {
            System.out.println("Singleton");
        }
        System.out.println();
        //endregion SINGLETON

        //region FACTORY
        System.out.println("==============FACTORY==============");
        Post post = FactoryPost.getPostType(Type.AWARD, "The walker - 1 month of no using the car");
        post.showPost();
        post = FactoryPost.getPostType(Type.CHALLENGE, "Selective collection");
        post.showPost();
        post = FactoryPost.getPostType(Type.FOLLOW, "Andrei");
        post.showPost();
        post = FactoryPost.getPostType(Type.MILESTONE, "24 weeks");
        post.showPost();
        System.out.println();
        //endregion FACTORY

        //region BUILDER
        System.out.println("==============BUILDER==============");

        List<Stage> recycleMainStages = Arrays.asList(
                new SimpleStage(),
                new SimpleStage(),
                new ComplexStage());
        Challenge recycle = new Challenge.ChallengeBuilder("recycle", recycleMainStages, ChallengeType.ENVIRONMENTAL)
                .makeVisible()
                .setCreator("Andrei Tecsor")
                .addIntermediaryStage(new ComplexStage())
                .addIntermediaryStage(new SimpleStage())
                .setCreationDate(LocalDate.of(2021, 3, 24))
                .build();
        System.out.println(recycle);
        System.out.println();

        List<Stage> noCarMainStage = Arrays.asList(
                new SimpleStage(),
                new ComplexStage(),
                new ComplexStage(),
                new ComplexStage());
        Challenge noCar = new Challenge.ChallengeBuilder("no car", noCarMainStage, ChallengeType.SELF_CENTERED)
                .addIntermediaryStage(new SimpleStage())
                .addIntermediaryStage(new ComplexStage())
                .addIntermediaryStage(new ComplexStage())
                .build();
        System.out.println(noCar);

        //endregion BUILDER
    }
}
