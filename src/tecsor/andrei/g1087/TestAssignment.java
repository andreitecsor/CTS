package tecsor.andrei.g1087;

import tecsor.andrei.g1087.adapter.*;
import tecsor.andrei.g1087.builder.*;
import tecsor.andrei.g1087.decorator.*;
import tecsor.andrei.g1087.factory.FactoryPost;
import tecsor.andrei.g1087.factory.Post;
import tecsor.andrei.g1087.factory.Type;
import tecsor.andrei.g1087.flyweight.BadgeDetails;
import tecsor.andrei.g1087.flyweight.BadgeFactory;
import tecsor.andrei.g1087.flyweight.BadgeType;
import tecsor.andrei.g1087.flyweight.Model3D;
import tecsor.andrei.g1087.prototype.Badge;
import tecsor.andrei.g1087.prototype.ColourStyle;
import tecsor.andrei.g1087.proxy.PictureUpload;
import tecsor.andrei.g1087.proxy.ProfilePicture;
import tecsor.andrei.g1087.proxy.ProxyPictureUpload;
import tecsor.andrei.g1087.proxy.exception.UploadFailedException;
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
            System.out.println("Indeed is singleton");
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
        System.out.println();

        //endregion BUILDER

        //region PROTOTYPE
        System.out.println("==============PROTOTYPE==============");
        try {
            Badge badge = new Badge(ColourStyle.BRONZE, "resources/recycleLogo.svg");
            Badge clonedBadge1 = badge.clone();
            Badge clonedBadge2 = badge.clone();
            System.out.println(badge);
            System.out.println(clonedBadge1);
            System.out.println(clonedBadge2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println();

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

        //region PROXY
        System.out.println("==============PROXY==============");
        PictureUpload picture1 = new ProfilePicture("picture1.jpeg", 26_000_000.0);
        picture1.upload();
        picture1.show();

        try {
            PictureUpload picture1Proxy = new ProxyPictureUpload(picture1);
            picture1Proxy.upload();
            picture1Proxy.show();
        } catch (UploadFailedException e) {
            e.printStackTrace();
        }

        PictureUpload picture2 = new ProfilePicture("picture2.jpeg", 18_000_000.0);
        PictureUpload picture2Proxy = new ProxyPictureUpload(picture2);
        picture2Proxy.upload();
        picture2Proxy.show();
        System.out.println();
        //endregion PROXY

        //region FLYWEIGHT
        System.out.println("==============FLYWEIGHT==============");
        BadgeDetails badgeDetails1 = new BadgeDetails("Andrei",
                "src/main/resources/assets/ch1.svg",
                LocalDate.now());
        BadgeDetails badgeDetails2 = new BadgeDetails("Marius",
                "src/main/resources/assets/ch5.svg",
                LocalDate.of(2021, 5, 1));
        BadgeDetails badgeDetails3 = new BadgeDetails("Tecsor",
                "src/main/resources/assets/ch3.svg",
                LocalDate.of(2021, 3, 3));
        Model3D silverBadge = BadgeFactory.getBadgeModel(BadgeType.SILVER);
        Model3D silverBadge2 = BadgeFactory.getBadgeModel(BadgeType.SILVER);
        Model3D platinumBadge = BadgeFactory.getBadgeModel(BadgeType.PLATINUM);
        silverBadge.show(badgeDetails1);
        silverBadge.show(badgeDetails2);
        silverBadge.show(badgeDetails3);
        platinumBadge.show(badgeDetails2);
        if (silverBadge.equals(silverBadge2)) {
            System.out.println("Unique silver badge");
        }
        System.out.println();
        //endregion FLYWEIGHT

        //region COMPOSITE
        System.out.println("==============COMPOSITE==============");
        tecsor.andrei.g1087.composite.Challenge challenge = new tecsor.andrei.g1087.composite.Challenge("No car");
        challenge.addNode(new tecsor.andrei.g1087.composite.Stage("2 days per week no car", 4));
        challenge.addNode(new tecsor.andrei.g1087.composite.Stage("3 days per week no car", 6));
        challenge.addNode(new tecsor.andrei.g1087.composite.Stage("4 days per week no car", 8));
        System.out.println("Total weeks to complete all stages: " + challenge.getCondition());
        tecsor.andrei.g1087.composite.Challenge expertChallenge = new tecsor.andrei.g1087.composite.Challenge("No car expert");
        expertChallenge.addNode(challenge);
        if (expertChallenge.isCompleted()) {
            System.out.println("All the challenges and stages are completed");
        }
        expertChallenge.complete();
        if (expertChallenge.isCompleted()) {
            System.out.println("All the challenges and stages are completed");
        }
        //endregion COMPOSITE
    }
}
