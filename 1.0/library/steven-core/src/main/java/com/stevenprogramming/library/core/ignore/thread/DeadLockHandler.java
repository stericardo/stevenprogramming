package com.stevenprogramming.library.core.ignore.thread;

import java.lang.management.ThreadInfo;

/**
 *
 * @author steven mendez
 * @since 14 Jan 2018
 * @version 1.0
 */
public interface DeadLockHandler {

  void handleDeadlock(final ThreadInfo[] deadlockedThreads);

}
