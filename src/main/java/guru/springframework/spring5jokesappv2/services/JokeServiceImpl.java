package guru.springframework.spring5jokesappv2.services;

import org.springframework.stereotype.Service;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public JokeServiceImpl() {
        this.chuckNorrisQuotes = new ChuckNorrisQuotes(); // we won't use DI for this 3rd party lib for now
    }

    public String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
