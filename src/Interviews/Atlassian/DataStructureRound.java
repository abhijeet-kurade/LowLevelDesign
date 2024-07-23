package Interviews.Atlassian;

import java.util.*;
import java.util.stream.Collectors;

public class DataStructureRound {
    public static void main(String[] args) {
        System.out.println("Hello World!!");
        Program p = new Program();

        List<Ballot> ballots = Arrays.asList(
                new Ballot("p5", "p2", "p4"),
                new Ballot("p3", "p1", "p4"),
                new Ballot("p5", "p1", "p2"),
                new Ballot("p5", "p2", "p1"),
                new Ballot("p5", "p1", "p4")
        );
        /*
         * p1 = 2 + 2 + 1 + 2 = 7
         * p2 = 2 + 1 + 2 = 5
         * p4 = 1 + 1 + 1 = 3
         * p3 = 3 = 3
         * p5 = 3 + 3 + 3 + 3 = 12
         * */

        System.out.println(getResults2(ballots));
    }

    static class Ballot{
        String first;
        String second;
        String third;

        public Ballot(String first, String second, String third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    static class Candidate{
        String name;
        int vote;

        int peopleVoted;

        public Candidate(String name, int vote, int peopleVoted) {
            this.name = name;
            this.vote = vote;
            this.peopleVoted = peopleVoted;
        }
    }

    /*
     * n is the number of ballots
     * TC : O(n lg n)
     * SC : O(n)
     * */
    static List<String> getResults(List<Ballot> ballots){

        Map<String, Integer> votes = new HashMap<>();
        Map<String, Integer> peopleVoted = new HashMap<>();

        for(Ballot b : ballots){
            votes.put(b.first, votes.getOrDefault(b.first, 0) + 3);
            votes.put(b.second, votes.getOrDefault(b.second, 0) + 2);
            votes.put(b.third, votes.getOrDefault(b.third, 0) + 1);

            peopleVoted.put(b.first, peopleVoted.getOrDefault(b.first, 0) + 1);
            peopleVoted.put(b.second, peopleVoted.getOrDefault(b.second, 0) + 1);
            peopleVoted.put(b.third, peopleVoted.getOrDefault(b.third, 0) + 1);
        }

        List<Candidate> candidates = new ArrayList<>();
        for(String candidate : votes.keySet()){
            candidates.add(new Candidate(candidate, votes.get(candidate), peopleVoted.get(candidate)));
        }

        Collections.sort(candidates, (o1, o2)-> {
            if(o2.vote != o1.vote) return o2.vote - o1.vote;
            return o2.peopleVoted - o1.peopleVoted;
        });

        List<String> topCandidates = candidates.stream().map((o)->{return o.name;}).collect(Collectors.toList());

        return topCandidates;
    }

    static List<String> getResults1(List<Ballot> ballots){

        Map<String, Integer> indexes = new HashMap<>();
        List<Candidate> candidates = new ArrayList<>();

        for(Ballot ballot : ballots){
            handleVoting(ballot.first, 3, indexes, candidates);
            handleVoting(ballot.second, 2, indexes, candidates);
            handleVoting(ballot.third, 1, indexes, candidates);
        }

        Collections.sort(candidates, (o1, o2)-> {
            if(o2.vote != o1.vote) return o2.vote - o1.vote;
            return o2.peopleVoted - o1.peopleVoted;
        });

        List<String> topCandidates = candidates.stream().map((o)->{return o.name;}).collect(Collectors.toList());

        return topCandidates;
    }

    public static void handleVoting(String candidate, int votes, Map<String, Integer> indexes, List<Candidate> candidates){
        if(!indexes.containsKey(candidate)){
            candidates.add(new Candidate(candidate, 0, 0));
            indexes.put(candidate, candidates.size() - 1);
        }
        candidates.get(indexes.get(candidate)).vote += votes;
        candidates.get(indexes.get(candidate)).peopleVoted += 1;
    }

    static List<String> getResults2(List<Ballot> ballots){

        Map<String, Candidate> candidates = new HashMap<>();

        for(Ballot ballot : ballots){
            handleVoting(ballot.first, 3, candidates);
            handleVoting(ballot.second, 2, candidates);
            handleVoting(ballot.third, 1, candidates);
        }

        List<Candidate> listOfCandidates = new ArrayList<>(candidates.values());

        Collections.sort(listOfCandidates, (o1, o2)-> {
            if(o2.vote != o1.vote) return o2.vote - o1.vote;
            return o2.peopleVoted - o1.peopleVoted;
        });

        List<String> topCandidates = listOfCandidates.stream().map((o)->{return o.name;}).collect(Collectors.toList());

        return topCandidates;
    }

    public static void handleVoting(String candidate, int votes, Map<String, Candidate> candidates){
        if(!candidates.containsKey(candidate)){
            candidates.put(candidate, new Candidate(candidate, 0, 0));
        }
        candidates.get(candidate).vote += votes;
        candidates.get(candidate).peopleVoted += 1;
    }
}

