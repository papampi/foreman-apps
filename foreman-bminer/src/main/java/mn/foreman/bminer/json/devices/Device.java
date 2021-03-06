package mn.foreman.bminer.json.devices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The following model provides a sub-model object of a response from bminer:
 *
 * <pre>
 *     GET /api/v1/status/device
 * </pre>
 *
 * <p>The expected format of that sub-object response is:</p>
 *
 * <pre>
 * {
 *   "temperature": 83,
 *   "power": 199,
 *   "fan_speed": 74,
 *   "global_memory_used": 4385,
 *   "utilization": {
 *     "gpu": 100,
 *     "memory": 73
 *   },
 *   "clocks": {
 *     "core": 1809,
 *     "memory": 5005
 *   }
 * }
 * </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {

    /** The clocks. */
    @JsonProperty("clocks")
    public Clocks clocks;

    /** The fan speed. */
    @JsonProperty("fan_speed")
    public int fanSpeed;

    /** The temperature. */
    @JsonProperty("temperature")
    public int temperature;
}
