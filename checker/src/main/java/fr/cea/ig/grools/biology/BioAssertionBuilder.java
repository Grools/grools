package fr.cea.ig.grools.biology;

import fr.cea.ig.grools.model.Evidence;
import fr.cea.ig.grools.model.FiveState;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

public final class BioAssertionBuilder {
    private String      id              = "";
    private String      name            = "";
    private String      knowledgeId     = "";
    private String      source          = "";
    private DateTime    date            = DateTime.now();
    private FiveState presence        = FiveState.TRUE;
    private Evidence evidence        = Evidence.MEDIUM;

    @NotNull
    public BioAssertionBuilder setName(@NotNull final String name) {
        this.name = name;
        return this;
    }

    @NotNull
    public BioAssertionBuilder setId(@NotNull final String id) {
        this.id = id;
        return this;
    }

    @NotNull
    public BioAssertionBuilder setKnowledgeId(@NotNull final String knowledgeId) {
        this.knowledgeId = knowledgeId;
        return this;
    }

    @NotNull
    public BioAssertionBuilder setSource(@NotNull final String source) {
        this.source = source;
        return this;
    }

    @NotNull
    public BioAssertionBuilder setDate(@NotNull final DateTime date) {
        this.date = date;
        return this;
    }

    @NotNull
    public BioAssertionBuilder setPresence(@NotNull final FiveState presence) {
        this.presence = presence;
        return this;
    }

    @NotNull
    public BioAssertionBuilder setEvidence(@NotNull final Evidence evidence) {
        this.evidence = evidence;
        return this;
    }

    @NotNull
    public BioAssertion create() {
        if ( id.isEmpty() ){
            assert (!name.isEmpty());
            id = name;
        }
        return new BioAssertion(id, name, knowledgeId, source, date, presence, evidence);
    }
}
