package game;

public enum Combinations {
    Ones{

    },
    Twos{

    },
    Threes{

    },
    Fours{

    },
    Fives{

    },
    Sixes{

    },
    ThreeOfAKind{
        public String getName(){
            return "Three Of A Kind";
        }

        public int getScore(int[] nums, String counts){
            int score = 0;
            if(counts.contains("3")){
                for(int i: nums){
                    score += i;
                }
            }
            return score;
        }
    },
    FourOfAKind{
        public String getName(){
            return "Four Of A Kind";
        }
        public int getScore(int[] nums, String counts){
            int score = 0;
            if(counts.contains("4")){
                for(int i: nums){
                    score += i;
                }
            }
            return score;
        }
    },
    FullHouse{
        public String getName(){
            return "Full House";
        }
        public int getScore(int[] nums, String counts){
            int score = 0;
            if(counts.contains("3") && counts.contains("2")){
                    score = 25;
            }
            return score;
        }

    },
    SmallStraight{
        public String getName(){
            return "Small Straight";
        }
        public int getScore(int[] nums, String counts){
            int score = 0;
            if(counts.contains("1111")){
                    score = 30;
            }
            return score;
        }
    },
    LargeStraight{
        public String getName(){
            return "Large Straight";
        }
        public int getScore(int[] nums, String counts){
            int score = 0;
            if(counts.contains("11111")){
                score = 40;
            }
            return score;
        }
    },
    Chance{

        public int getScore(int[] nums, String counts){
            int score = 0;
                for(int i: nums){
                    score += i;
                }
            return score;
        }

    },
    Yahtzee{

        public int getScore(int[] nums, String counts){
            int score = 0;
            if(counts.contains("5")){
                score = 50;
            }
            return score;
        }
    };
    public String getName(){
        return name();
    }

    public int getScore(int[] nums, String counts){
        int score = 0;
        return score;
    }



}
