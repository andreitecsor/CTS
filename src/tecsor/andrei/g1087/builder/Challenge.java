package tecsor.andrei.g1087.builder;

import tecsor.andrei.g1087.builder.exception.InvalidChallengeException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Challenge {
    private String name;
    private LocalDate creationDate;
    private String creator;
    private ChallengeType type;
    private boolean isVisible;
    private List<Stage> mainStages;
    private List<Stage> intermediaryStage = new ArrayList<>();

    private Challenge() {
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", creator='" + creator + '\'' +
                ", type=" + type +
                ", isVisible=" + isVisible +
                ", mainStages=" + mainStages +
                ", intermediaryStage=" + intermediaryStage +
                '}';
    }

    public static class ChallengeBuilder {
        private Challenge challenge;

        public ChallengeBuilder(String name, List<Stage> mainStages, ChallengeType type) {
            if (mainStages.size() < 3) {
                throw new InvalidChallengeException("Your challenge must have at least 3 main stages");
            }
            this.challenge = new Challenge();
            this.challenge.name = name;
            this.challenge.mainStages = mainStages;
            this.challenge.type = type;
            this.challenge.creator = "ZA TEAM";
            this.challenge.creationDate = LocalDate.now();
        }

        public ChallengeBuilder makeVisible() {
            this.challenge.isVisible = true;
            return this;
        }

        public ChallengeBuilder makeInvisible() {
            if (this.challenge.isVisible) {
                this.challenge.isVisible = false;
            }
            return this;
        }

        public ChallengeBuilder addIntermediaryStage(Stage intermediaryStage) {
            if (intermediaryStage != null) {
                this.challenge.intermediaryStage.add(intermediaryStage);
            }
            return this;
        }

        public ChallengeBuilder setCreator(String creator) {
            if (creator != null) {
                this.challenge.creator = creator;
            }
            return this;
        }

        public ChallengeBuilder setCreationDate(LocalDate launchDate) {
            if (launchDate.isAfter(LocalDate.now())) {
                throw new InvalidChallengeException("You cannot set creation date in the future");
            }
            this.challenge.creationDate = launchDate;
            return this;
        }

        public Challenge build() {
            return this.challenge;
        }

    }
}
