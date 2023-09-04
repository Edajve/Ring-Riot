package matchTest;

import org.boxingTournament.match.Match;
import org.boxingTournament.match.StatisticsAndOutcomes;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class MatchClassTest {

    /**
     * Don't neet do test simulateRounds() because its is a private methods, but its being called
     * withing returnFightResults() so we will be indirectly testing this method via another.
     * It was manually validated, and it looks good, all the rounds seem random and not clear
     * pattern. LGTM
     */
}
