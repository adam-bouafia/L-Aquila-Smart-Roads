/**
 * Represents an amend.
 */
export interface Amend {
  /**
   * The ID of the amend.
   */
  id: number;

  /**
   * The date of the amend.
   */
  date: any;

  /**
   * The ID of the monitor associated with the amend.
   */
  monitorId: number;

  /**
   * Indicates whether the amend has been paid or not.
   */
  paid: boolean;

  /**
   * The matricule of the vehicle associated with the amend.
   */
  vehicleMatricule: string;

  /**
   * The vehicle associated with the amend.
   */
  vehicle: any;

  /**
   * The speed of the vehicle at the time of the amend.
   */
  vehicleSpeed: number;

  /**
   * The monitor associated with the amend.
   */
  monitor: any;

  /**
   * The maximum speed allowed by the monitor.
   */
  monitorMaxSpeed: number;

  /**
   * The amount of the amend.
   */
  amendAmount: number;
}
