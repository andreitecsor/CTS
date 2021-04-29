package tecsor.andrei.g1087;

import tecsor.andrei.g1087.adapter.*;
import tecsor.andrei.g1087.decorator.*;

public class TestAssignment {
    public static void main(String[] args) {
        //region SINGLETON
//        System.out.println("==============SINGLETON==============");
//        Neo4JConnection connection = Neo4JConnection.getInstance();
//        Neo4JConnection connection2 = Neo4JConnection.getInstance();
//        System.out.println(connection);
//        System.out.println(connection2);
//        if (connection.equals(connection2)) {
//            System.out.println("Singleton");
//        }
//        System.out.println();
        //endregion SINGLETON

        //region FACTORY
//        System.out.println("==============FACTORY==============");
//        Post post = FactoryPost.getPostType(Type.AWARD, "The walker - 1 month of no using the car");
//        post.showPost();
//        post = FactoryPost.getPostType(Type.CHALLENGE, "Selective collection");
//        post.showPost();
//        post = FactoryPost.getPostType(Type.FOLLOW, "Andrei");
//        post.showPost();
//        post = FactoryPost.getPostType(Type.MILESTONE, "24 weeks");
//        post.showPost();
//        System.out.println();
        //endregion FACTORY

        //region BUILDER
//        System.out.println("==============BUILDER==============");
//
//        List<Stage> recycleMainStages = Arrays.asList(
//                new SimpleStage(),
//                new SimpleStage(),
//                new ComplexStage());
//        Challenge recycle = new Challenge.ChallengeBuilder("recycle", recycleMainStages, ChallengeType.ENVIRONMENTAL)
//                .makeVisible()
//                .setCreator("Andrei Tecsor")
//                .addIntermediaryStage(new ComplexStage())
//                .addIntermediaryStage(new SimpleStage())
//                .setCreationDate(LocalDate.of(2021, 3, 24))
//                .build();
//        System.out.println(recycle);
//        System.out.println();
//
//        List<Stage> noCarMainStage = Arrays.asList(
//                new SimpleStage(),
//                new ComplexStage(),
//                new ComplexStage(),
//                new ComplexStage());
//        Challenge noCar = new Challenge.ChallengeBuilder("no car", noCarMainStage, ChallengeType.SELF_CENTERED)
//                .addIntermediaryStage(new SimpleStage())
//                .addIntermediaryStage(new ComplexStage())
//                .addIntermediaryStage(new ComplexStage())
//                .build();
//        System.out.println(noCar);
//        System.out.println();

        //endregion BUILDER

        //region PROTOTYPE
//        System.out.println("==============PROTOTYPE==============");
//        try {
//            Badge badge = new Badge(ColourStyle.BRONZE, "resources/recycleLogo.svg");
//            Badge clonedBadge1 = badge.clone();
//            Badge clonedBadge2 = badge.clone();
//            System.out.println(badge);
//            System.out.println(clonedBadge1);
//            System.out.println(clonedBadge2);
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        System.out.println();

        //endregion PROTOTYPE

        //region DECORATOR
        System.out.println("==============DECORATOR==============");
        User user = new User("andrei_t", "Andrei Tecsor");
        Profile profile = new ProfileImpl(user);
        profile.showProfile();
        profile.getUser().increaseGreenPoints(100.0);
        profile = new NatureDecorator(profile, 1, 3, 5, 6);
        profile.showProfile();
        profile.getUser().increaseGreenPoints(1200.0);
        profile.getUser().setDisplayName("Anonymous Andrei");
        profile = new ScoutDecorator(profile, true);
        profile.showProfile();
        System.out.println();
        //endregion DECORATOR

        //region ADAPTER
        System.out.println("==============ADAPTER==============");
        User userAdapter = new User("andrei_t", "Andrei Tecsor");
        AvatarReactions avatarReactions = new Avatar(userAdapter, Gender.MALE);
        avatarReactions.amazed();
        avatarReactions.wink();
        avatarReactions.smile();
        System.out.println();
        User userAdapter2 = new User("i_andrei", "Andrei Apple Fanboy");
        Memoji memoji = new Memoji(true, false, Age.YOUNG);
        AvatarReactions userAdapter2Memoji = new MemojiAvatarAdapter(userAdapter2, memoji);
        userAdapter2Memoji.amazed();
        userAdapter2Memoji.wink();
        userAdapter2Memoji.smile();
        System.out.println();
        //endregion ADAPTER
    }
}
