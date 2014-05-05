import scala.io.Source

val cards = List('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');

val ranks = List("High Card", "One Pair", "Two Pairs", "Three of a Kind", "Straight", "Flush", "Full House", "Four of a Kind", "Straight Flush", "Royal Flush");

type Score = Pair[String, List[Char]];

type Hand = List[String]

def sortHand(hand: Hand): Hand = {
  hand.sortWith((x, y) => cards.indexOf(x(0)) < cards.indexOf(y(0))).reverse
}

def score(hand: Hand): Score = {
  val royalFlush = isRoyalFlush(hand);
  if (royalFlush._1 == ranks(9)) return royalFlush;
  val straightFlush = isStraightFlush(hand);
  if (straightFlush._1 == ranks(8)) return straightFlush;
  val four = isFour(hand);
  if (four._1 == ranks(7)) return four;
  val full = isFull(hand);
  if (full._1 == ranks(6)) return full;
  val flush = isFlush(hand);
  if (flush._1 == ranks(5)) return flush;
  val straight = isStraight(hand);
  if (straight._1 == ranks(4)) return straight;
  val three = isThreeOfAKind(hand);
  if (three._1 == ranks(3)) return three;
  val twoPairs = isTwoPairs(hand);
  if (twoPairs._1 == ranks(2)) return twoPairs;
  val onePair = isOnePair(hand);
  if (onePair._1 == ranks(1)) return onePair;
  val highCard = isHighCard(hand);
  if (highCard._1 == ranks(0)) return highCard;
  return highCard;
}

def isPlayerOneWon(playerOneScore: Score, playerTwoScore: Score): Boolean = {
  if (ranks.indexOf(playerOneScore._1) > ranks.indexOf(playerTwoScore._1)) return true;
  if (ranks.indexOf(playerOneScore._1) < ranks.indexOf(playerTwoScore._1)) return false;
  if (ranks.indexOf(playerOneScore._1) == 0) {
    if (cards.indexOf(playerOneScore._2(0)) > cards.indexOf(playerTwoScore._2(0))) return true;
    if (cards.indexOf(playerOneScore._2(0)) < cards.indexOf(playerTwoScore._2(0))) return false;
    if (cards.indexOf(playerOneScore._2(1)) > cards.indexOf(playerTwoScore._2(1))) return true;
    if (cards.indexOf(playerOneScore._2(1)) < cards.indexOf(playerTwoScore._2(1))) return false;
    if (cards.indexOf(playerOneScore._2(2)) > cards.indexOf(playerTwoScore._2(2))) return true;
    if (cards.indexOf(playerOneScore._2(2)) < cards.indexOf(playerTwoScore._2(2))) return false;
    if (cards.indexOf(playerOneScore._2(3)) > cards.indexOf(playerTwoScore._2(3))) return true;
    if (cards.indexOf(playerOneScore._2(3)) < cards.indexOf(playerTwoScore._2(3))) return false;
    if (cards.indexOf(playerOneScore._2(4)) > cards.indexOf(playerTwoScore._2(4))) return true;
    if (cards.indexOf(playerOneScore._2(4)) < cards.indexOf(playerTwoScore._2(4))) return false;
  }
  if (ranks.indexOf(playerOneScore._1) == 1) {
    if (cards.indexOf(playerOneScore._2(0)) > cards.indexOf(playerTwoScore._2(0))) return true;
    if (cards.indexOf(playerOneScore._2(0)) < cards.indexOf(playerTwoScore._2(0))) return false;
    if (cards.indexOf(playerOneScore._2(1)) > cards.indexOf(playerTwoScore._2(1))) return true;
    if (cards.indexOf(playerOneScore._2(1)) < cards.indexOf(playerTwoScore._2(1))) return false;
    if (cards.indexOf(playerOneScore._2(2)) > cards.indexOf(playerTwoScore._2(2))) return true;
    if (cards.indexOf(playerOneScore._2(2)) < cards.indexOf(playerTwoScore._2(2))) return false;
    if (cards.indexOf(playerOneScore._2(3)) > cards.indexOf(playerTwoScore._2(3))) return true;
    if (cards.indexOf(playerOneScore._2(3)) < cards.indexOf(playerTwoScore._2(3))) return false;
  }
  if (ranks.indexOf(playerOneScore._1) == 2) {
    if (cards.indexOf(playerOneScore._2(0)) > cards.indexOf(playerTwoScore._2(0))) return true;
    if (cards.indexOf(playerOneScore._2(0)) < cards.indexOf(playerTwoScore._2(0))) return false;
    if (cards.indexOf(playerOneScore._2(1)) > cards.indexOf(playerTwoScore._2(1))) return true;
    if (cards.indexOf(playerOneScore._2(1)) < cards.indexOf(playerTwoScore._2(1))) return false;
    if (cards.indexOf(playerOneScore._2(2)) > cards.indexOf(playerTwoScore._2(2))) return true;
    if (cards.indexOf(playerOneScore._2(2)) < cards.indexOf(playerTwoScore._2(2))) return false;
  }
  if (ranks.indexOf(playerOneScore._1) == 3) {
    if (cards.indexOf(playerOneScore._2(0)) > cards.indexOf(playerTwoScore._2(0))) return true;
    if (cards.indexOf(playerOneScore._2(0)) < cards.indexOf(playerTwoScore._2(0))) return false;
    if (cards.indexOf(playerOneScore._2(1)) > cards.indexOf(playerTwoScore._2(1))) return true;
    if (cards.indexOf(playerOneScore._2(1)) < cards.indexOf(playerTwoScore._2(1))) return false;
  }
  if (ranks.indexOf(playerOneScore._1) == 4) {
    if (cards.indexOf(playerOneScore._2(0)) > cards.indexOf(playerTwoScore._2(0))) return true;
    if (cards.indexOf(playerOneScore._2(0)) < cards.indexOf(playerTwoScore._2(0))) return false;
  }
  if (ranks.indexOf(playerOneScore._1) == 5) {
    if (cards.indexOf(playerOneScore._2(0)) > cards.indexOf(playerTwoScore._2(0))) return true;
    if (cards.indexOf(playerOneScore._2(0)) < cards.indexOf(playerTwoScore._2(0))) return false;
    if (cards.indexOf(playerOneScore._2(1)) > cards.indexOf(playerTwoScore._2(1))) return true;
    if (cards.indexOf(playerOneScore._2(1)) < cards.indexOf(playerTwoScore._2(1))) return false;
    if (cards.indexOf(playerOneScore._2(2)) > cards.indexOf(playerTwoScore._2(2))) return true;
    if (cards.indexOf(playerOneScore._2(2)) < cards.indexOf(playerTwoScore._2(2))) return false;
    if (cards.indexOf(playerOneScore._2(3)) > cards.indexOf(playerTwoScore._2(3))) return true;
    if (cards.indexOf(playerOneScore._2(3)) < cards.indexOf(playerTwoScore._2(3))) return false;
    if (cards.indexOf(playerOneScore._2(4)) > cards.indexOf(playerTwoScore._2(4))) return true;
    if (cards.indexOf(playerOneScore._2(4)) < cards.indexOf(playerTwoScore._2(4))) return false;
  }
  if (ranks.indexOf(playerOneScore._1) == 6) {
    if (cards.indexOf(playerOneScore._2(0)) > cards.indexOf(playerTwoScore._2(0))) return true;
    if (cards.indexOf(playerOneScore._2(0)) < cards.indexOf(playerTwoScore._2(0))) return false;
    if (cards.indexOf(playerOneScore._2(1)) > cards.indexOf(playerTwoScore._2(1))) return true;
    if (cards.indexOf(playerOneScore._2(1)) < cards.indexOf(playerTwoScore._2(1))) return false;
  }
  if (ranks.indexOf(playerOneScore._1) == 7) {
    if (cards.indexOf(playerOneScore._2(0)) > cards.indexOf(playerTwoScore._2(0))) return true;
    if (cards.indexOf(playerOneScore._2(0)) < cards.indexOf(playerTwoScore._2(0))) return false;
    if (cards.indexOf(playerOneScore._2(1)) > cards.indexOf(playerTwoScore._2(1))) return true;
    if (cards.indexOf(playerOneScore._2(1)) < cards.indexOf(playerTwoScore._2(1))) return false;
  }
  if (ranks.indexOf(playerOneScore._1) == 8) {
    if (cards.indexOf(playerOneScore._2(0)) > cards.indexOf(playerTwoScore._2(0))) return true;
    if (cards.indexOf(playerOneScore._2(0)) < cards.indexOf(playerTwoScore._2(0))) return false;
  }
  if (ranks.indexOf(playerOneScore._1) == 9) {
    if (cards.indexOf(playerOneScore._2(0)) > cards.indexOf(playerTwoScore._2(0))) return true;
    if (cards.indexOf(playerOneScore._2(0)) < cards.indexOf(playerTwoScore._2(0))) return false;
  }
  return false;
}

def isHighCard(hand: Hand): Score = {
  val ls = sortHand(hand).map(_(0));
  (ranks(0), ls);
}

def isOnePair(hand: Hand): Score = {
  val sh = sortHand(hand);
  if (sh(0)(0) == sh(1)(0)) 
    return (ranks(1), List(sh(0)(0), sh(2)(0), sh(3)(0), sh(4)(0)));
  if (sh(1)(0) == sh(2)(0)) 
    return (ranks(1), List(sh(1)(0), sh(0)(0), sh(3)(0), sh(4)(0)));
  if (sh(2)(0) == sh(3)(0)) 
    return (ranks(1), List(sh(2)(0), sh(0)(0), sh(1)(0), sh(4)(0)));
  if (sh(3)(0) == sh(4)(0))
    return (ranks(1), List(sh(3)(0), sh(0)(0), sh(1)(0), sh(2)(0)));
  return ("", List());
}

def isTwoPairs(hand: Hand): Score = {
  val sh = sortHand(hand);
  if (sh(0)(0) == sh(1)(0) && sh(2)(0) == sh(3)(0)) 
    return (ranks(2), List(sh(0)(0), sh(2)(0), sh(4)(0)));
  if (sh(0)(0) == sh(1)(0) && sh(2)(0) == sh(4)(0)) 
    return (ranks(2), List(sh(0)(0), sh(2)(0), sh(3)(0)));
  if (sh(0)(0) == sh(1)(0) && sh(3)(0) == sh(4)(0)) 
    return (ranks(2), List(sh(0)(0), sh(3)(0), sh(2)(0)));
  if (sh(0)(0) == sh(2)(0) && sh(3)(0) == sh(4)(0))
    return (ranks(2), List(sh(0)(0), sh(3)(0), sh(1)(0)));
  if (sh(1)(0) == sh(2)(0) && sh(3)(0) == sh(4)(0)) 
    return (ranks(2), List(sh(1)(0), sh(3)(0), sh(0)(0)));
  return ("", List());
}

def isThreeOfAKind(hand: Hand): Score = {
  val sh = sortHand(hand);
  if (sh(0)(0) == sh(1)(0) && sh(0)(0) == sh(2)(0)) 
    return (ranks(3), List(sh(0)(0), sh(3)(0), sh(4)(0)));
  if (sh(1)(0) == sh(2)(0) && sh(1)(0) == sh(3)(0)) 
    return (ranks(3), List(sh(1)(0), sh(0)(0), sh(4)(0)));
  if (sh(2)(0) == sh(3)(0) && sh(2)(0) == sh(4)(0)) 
    return (ranks(3), List(sh(2)(0), sh(0)(0), sh(1)(0)));
  return ("", List());
}

def isStraight(hand: Hand): Score = {
  val sh = sortHand(hand);
  if (cards.indexOf(sh(0)(0)) - cards.indexOf(sh(1)(0)) == 1)
    if (cards.indexOf(sh(1)(0)) - cards.indexOf(sh(2)(0)) == 1)
      if (cards.indexOf(sh(2)(0)) - cards.indexOf(sh(3)(0)) == 1)
        if (cards.indexOf(sh(3)(0)) - cards.indexOf(sh(4)(0)) == 1)
          return (ranks(4), List(sh(0)(0)));
  return ("", List());
}

def isFlush(hand: Hand): Score = {
  val sh = sortHand(hand);
  if (sh(0)(1) == sh(1)(1) && sh(0)(1) == sh(2)(1)) 
    if (sh(0)(1) == sh(3)(1) && sh(0)(1) == sh(4)(1)) 
      return (ranks(5), sh.map(_(0)));
  return ("", List());
}

def isFull(hand: Hand): Score = {
  val sh = sortHand(hand);
  if (sh(0)(0) == sh(1)(0) && sh(0)(0) == sh(2)(0)) 
    if (sh(3)(0) == sh(4)(0)) 
      return (ranks(6), List(sh(0)(0), sh(3)(0)));
  if (sh(2)(0) == sh(3)(0) && sh(2)(0) == sh(4)(0)) 
    if (sh(0)(0) == sh(1)(0)) 
      return (ranks(6), List(sh(2)(0), sh(0)(0)));
  return ("", List());
}

def isFour(hand: Hand): Score = {
  val sh = sortHand(hand);
  if (sh(0)(0) == sh(1)(0) && sh(0)(0) == sh(2)(0)) 
    if (sh(0)(0) == sh(3)(0)) 
      return (ranks(7), List(sh(0)(0), sh(4)(0)));
  if (sh(1)(0) == sh(2)(0) && sh(1)(0) == sh(3)(0)) 
    if (sh(1)(0) == sh(4)(0)) 
      return (ranks(7), List(sh(1)(0), sh(0)(0)));
  return ("", List());
}

def isStraightFlush(hand: Hand): Score = {
  val sh = sortHand(hand);
  if (cards.indexOf(sh(0)(0)) - cards.indexOf(sh(1)(0)) == 1)
    if (cards.indexOf(sh(1)(0)) - cards.indexOf(sh(2)(0)) == 1)
      if (cards.indexOf(sh(2)(0)) - cards.indexOf(sh(3)(0)) == 1)
        if (cards.indexOf(sh(3)(0)) - cards.indexOf(sh(4)(0)) == 1)
          if (sh(0)(1) == sh(1)(1) && sh(0)(1) == sh(2)(1)) 
            if (sh(0)(1) == sh(3)(1) && sh(0)(1) == sh(4)(1)) 
              return (ranks(8), List(sh(0)(0)));
  return ("", List());
}

def isRoyalFlush(hand: Hand): Score = {
  val sh = sortHand(hand);
  if (cards.indexOf(sh(0)(0)) - cards.indexOf(sh(1)(0)) == 1)
    if (cards.indexOf(sh(1)(0)) - cards.indexOf(sh(2)(0)) == 1)
      if (cards.indexOf(sh(2)(0)) - cards.indexOf(sh(3)(0)) == 1)
        if (cards.indexOf(sh(3)(0)) - cards.indexOf(sh(4)(0)) == 1)
          if (sh(0)(1) == sh(1)(1) && sh(0)(1) == sh(2)(1)) 
            if (sh(0)(1) == sh(3)(1) && sh(0)(1) == sh(4)(1)) 
              if(sh(0)(0) == 'A')
                return (ranks(9), List(sh(0)(0)));
  return ("", List());
}

var playerOneHand = List("6H", "5H", "4H", "3H", "2H");
var playerTwoHand = List("AD", "TC", "JC", "QC", "KC");
var score1 = score(playerOneHand);
var score2 = score(playerTwoHand);

val l = "8C TS KC 9H 4S 7D 2S 5D 3S AC";
var ii = l.split(" ").toList;
println(l);


var n = 0;
val file = Source.fromFile("poker.txt").getLines().toList
for (i <- file) {
  ii = i.split(" ").toList;
  playerOneHand = List(ii(0), ii(1), ii(2), ii(3), ii(4));
  playerTwoHand = List(ii(5), ii(6), ii(7), ii(8), ii(9));
  score1 = score(playerOneHand);
  score2 = score(playerTwoHand);
  println(sortHand(playerOneHand), score1);
  println(sortHand(playerTwoHand), score2);
  if (isPlayerOneWon(score1, score2)) {
    n += 1;
    println("Player 1 won", n);
  }
  else println("Player 2 won");
}

