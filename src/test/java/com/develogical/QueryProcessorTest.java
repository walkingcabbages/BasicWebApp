package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsTeamName() throws Exception {
        assertThat(queryProcessor.process("what is your name"), containsString("what is going on"));
    }

    @Test
    public void knowsMaxNumber() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is the largest: 40, 300, 1"), containsString("300"));
    }

    @Test
    public void knowsSqrtAndCbrt() throws Exception {
        assertThat(queryProcessor.process("which of the following numbers is both a square and a cube: 4, 1, 2"), containsString("1"));
    }

}
