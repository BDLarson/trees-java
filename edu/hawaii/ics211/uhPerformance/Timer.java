package edu.hawaii.ics211.uhPerformance;

/**
 * Time how long it takes to do something.
 *
 * @author ICS 211 Student
 */
public class Timer {

  ///////////////////////////////////////////////////////////////////////////
  //  Constants & Member Variables

  /** A description of the thing being timed. */
  private String description;


  /**
   * When a timer is running, this holds a System.nanoTime() value.
   */
  private long startTime;


  /**
   * The duration of this timer in nanoseconds.
   */
  private long duration;


  /**
   * A temporary time holder.  This is held as a member variable for
   * performance reasons.
   */
  private long tempTime;


  ///////////////////////////////////////////////////////////////////////////
  //  Constructors

  /**
   * Construct a new timer object.
   *
   * @param inDescription A description of the thing being timed.
   */
  public Timer(final String description) {
    this.description = description;
    this.startTime = 0;
    this.duration = 0;
    this.tempTime = 0;
  }


  ///////////////////////////////////////////////////////////////////////////
  //  Getters and Setters

  /**
   * Get the description.
   *
   * @return The description of this timer.
   */
  public String getDescription() {
    return this.description;
  }


  /**
   * Set the description.
   *
   * @param description The description of this timer.
   */
  public void setDescription(final String description) {
    this.description = description;
  }


  ///////////////////////////////////////////////////////////////////////////
  //  Methods

  /**
   * Flush the memory heap by finalizing all objects that are done,
   * running the garbage collector, and pausing the JVM to actually
   * do garbage collection.
   */
  private static void flushMemoryHeap() {
    System.runFinalization();
    System.gc();
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  /**
   * Start the timer.
   *
   * @throws RuntimeException If the timer is already running.
   */
  public void start() {
    if (this.startTime != 0) {
      throw new RuntimeException(
          "Can't start this timer -- it's already running");
    }

    flushMemoryHeap();

    this.startTime = System.nanoTime();
  }


  /** Stop the timer.
   *
   * @throws RuntimeException If the timer is not yet running.
   */
  public void stop() {
    this.tempTime = System.nanoTime();

    if (this.startTime == 0) {
      throw new RuntimeException(
          "Can't stop this timer -- it's not running");
    }

    duration += this.tempTime - this.startTime;
    this.startTime = 0;
    this.tempTime = 0;

    flushMemoryHeap();
  }


  /**
   * Get the duration in nanoseconds.
   *
   * @return The duration in nanoseconds.
   */
  public long getDurationNs() {
    return this.duration;
  }

}
