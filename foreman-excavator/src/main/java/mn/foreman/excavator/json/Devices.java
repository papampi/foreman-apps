package mn.foreman.excavator.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The following model provides a model of a response from excavator:
 *
 * <pre>
 * {"id":1,"method":"devices.get","params":[]}
 * </pre>
 *
 * <p>The expected format of that response is:</p>
 *
 * <pre>
 * {
 *   "devices":[
 *     {
 *       "device_id":0,
 *       "name":"GeForce GTX 1080 Ti",
 *       "gpgpu_type":1,
 *       "subvendor":"10de",
 *       "details": {
 *         "cuda_id":0,
 *         "sm_major":6,
 *         "sm_minor":1,
 *         "bus_id":5
 *       },
 *       "uuid":"GPU-8f6552ba-76e8-4e86-c2bb-53b69fb685ef",
 *       "gpu_temp":28,
 *       "gpu_load":0,
 *       "gpu_load_memctrl":0,
 *       "gpu_power_mode":80.0,
 *       "gpu_power_usage":56.340999603271487,
 *       "gpu_power_limit_current":250.0,
 *       "gpu_power_limit_min":125.0,
 *       "gpu_power_limit_max":300.0,
 *       "gpu_tdp_current":100.0,
 *       "gpu_clock_core_max":1911,
 *       "gpu_clock_memory":5005,
 *       "gpu_fan_speed":23,
 *       "gpu_fan_speed_rpm":1036,
 *       "gpu_memory_free":10753101824,
 *       "gpu_memory_used":1058058240
 *     },
 *     {
 *       "device_id":1,
 *       "name":"GeForce GTX 1080",
 *       "gpgpu_type":1,
 *       "subvendor":"3842",
 *       "details": {
 *         "cuda_id":1,
 *         "sm_major":6,
 *         "sm_minor":1,
 *         "bus_id":7
 *       },
 *       "uuid":"GPU-c108e737-1a9a-2302-c878-402608fd4535",
 *       "gpu_temp":35,
 *       "gpu_load":0,
 *       "gpu_load_memctrl":0,
 *       "gpu_power_mode":-1.0,
 *       "gpu_power_usage":6.573999881744385,
 *       "gpu_power_limit_current":180.0,
 *       "gpu_power_limit_min":90.0,
 *       "gpu_power_limit_max":217.0,
 *       "gpu_tdp_current":100.0,
 *       "gpu_clock_core_max":2012,
 *       "gpu_clock_memory":4513,
 *       "gpu_fan_speed":0,
 *       "gpu_fan_speed_rpm":0,
 *       "gpu_memory_free":8471445504,
 *       "gpu_memory_used":118489088
 *     }
 *   ],
 *   "id":1,
 *   "error":null
 * }
 * </pre>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Devices
        implements Response {

    /** The {@link Devices devices}. */
    @JsonProperty("devices")
    public List<Device> devices;

    /** Provides a model representation of the {@link Device} object. */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Device {

        /** The {@link Details}. */
        @JsonProperty("details")
        public Details details;

        /** The device ID. */
        @JsonProperty("device_id")
        public int deviceId;

        /** The GPU core clock. */
        @JsonProperty("gpu_clock_core_max")
        public int gpuClockCoreMax;

        /** The GPU memory clock. */
        @JsonProperty("gpu_clock_memory")
        public int gpuClockMemory;

        /** The GPU fan speed (percentage). */
        @JsonProperty("gpu_fan_speed")
        public int gpuFanSpeed;

        /** The GPU temp. */
        @JsonProperty("gpu_temp")
        public int gpuTemp;

        /** The name. */
        @JsonProperty("name")
        public String name;

        /**
         * Provides a model representation of the {@link Devices'} details
         * object.
         */
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Details {

            /** The bus ID. */
            @JsonProperty("bus_id")
            public int busId;
        }
    }
}