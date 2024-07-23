/**
 * Represents a monitor object.
 */
export interface Monitor {
  /**
   * The unique identifier of the monitor.
   */
  id: number;

  /**
   * The name of the monitor.
   */
  name: string;

  /**
   * The maximum speed allowed by the monitor.
   */
  maxSpeed: number;

  /**
   * The status of the monitor.
   */
  status: boolean;

  /**
   * The longitude coordinate of the monitor's location.
   */
  longitude: number;

  /**
   * The latitude coordinate of the monitor's location.
   */
  latitude: number;
}

export interface PageMonitor {
  monitors: Monitor[];
  page: number;
  size: number;
  totalPages: number;
}
