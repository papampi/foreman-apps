package mn.foreman.cgminer.response;

import mn.foreman.model.AbstractBuilder;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.*;

/** A generic cgminer response. */
public class CgMinerResponse {

    /** The status sections. */
    private List<Map<String, String>> status;

    /** The returned values. */
    private Map<String, List<Map<String, String>>> values;

    /**
     * Constructor.
     *
     * @param status The status.
     * @param values The values.
     */
    private CgMinerResponse(
            final List<Map<String, String>> status,
            final Map<String, List<Map<String, String>>> values) {
        Validate.notNull(
                status,
                "status cannot be null");
        Validate.notEmpty(
                status,
                "status cannot be empty");
        this.status = new ArrayList<>(status);
        this.values = new HashMap<>(values);
    }

    @Override
    public boolean equals(final Object other) {
        final boolean isEqual;
        if (other == null) {
            isEqual = false;
        } else if (getClass() != other.getClass()) {
            isEqual = false;
        } else {
            final CgMinerResponse response = (CgMinerResponse) other;
            isEqual =
                    new EqualsBuilder()
                            .append(this.status,
                                    response.status)
                            .append(this.values,
                                    response.values)
                            .isEquals();
        }
        return isEqual;
    }

    /**
     * Returns the status.
     *
     * @return The status.
     */
    public List<Map<String, String>> getStatus() {
        return Collections.unmodifiableList(this.status);
    }

    /**
     * Returns the values.
     *
     * @return The values.
     */
    public Map<String, List<Map<String, String>>> getValues() {
        Map<String, List<Map<String, String>>> values = this.values;
        if (this.values == null) {
            values = Collections.emptyMap();
        }
        return Collections.unmodifiableMap(values);
    }

    /**
     * Checks to see if the response contains data.
     *
     * @return Whether or not the response contains data.
     */
    public boolean hasValues() {
        return ((isSuccess()) &&
                (this.values != null) &&
                (!this.values.isEmpty()));
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.status)
                .append(this.values)
                .hashCode();
    }

    /**
     * Checks whether all of the commands were successful.
     *
     * @return True if successful, false otherwise.
     */
    public boolean isSuccess() {
        return this.status
                .stream()
                .allMatch(status -> status.get("STATUS").equals("S"));
    }

    @Override
    public String toString() {
        return String.format(
                "%s [ status=%s, values=%s ]",
                getClass().getSimpleName(),
                this.status,
                this.values);
    }

    /** A builder for creating new {@link CgMinerResponse responses}. */
    public static class Builder
            extends AbstractBuilder<CgMinerResponse> {

        /** The status. */
        private final List<Map<String, String>> status =
                new LinkedList<>();

        /** The values. */
        private final Map<String, List<Map<String, String>>> values =
                new HashMap<>();

        /**
         * Adds the provided status.
         *
         * @param status The status.
         *
         * @return This builder instance.
         */
        public Builder addStatus(
                final Map<String, String> status) {
            this.status.add(status);
            return this;
        }

        /**
         * Adds all of the statuses.
         *
         * @param status The statuses.
         *
         * @return This builder instance.
         */
        public Builder addStatus(
                final List<Map<String, String>> status) {
            this.status.addAll(status);
            return this;
        }

        /**
         * Adds the provided values.
         *
         * @param values The values.
         *
         * @return The builder instance.
         */
        public Builder addValues(
                final String key,
                final Map<String, String> values) {
            final List<Map<String, String>> currentValues =
                    this.values.computeIfAbsent(
                            key,
                            (value) -> new LinkedList<>());
            currentValues.add(values);
            return this;
        }

        @Override
        public CgMinerResponse build() {
            return new CgMinerResponse(
                    this.status,
                    this.values);
        }
    }
}