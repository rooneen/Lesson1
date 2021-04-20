package ru.geekbrains.Lesson14.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// уровни логгирования
// OFF < TRACE < DEBUG < INFO < WARN < ERROR < FATAL < ALL
public class Log {
    private static final Logger log = LogManager.getLogger(Log.class);

    public static void main(String[] args) {
        log.trace("Trace {}", 1);
        log.debug("Debug {}", 2);
        log.info("info {}", 3);
        log.warn("warn {}", 4);
        log.error("error {}", 5);
        log.error("Message {}, {}", "Что-то произошло", "Непонятно что");
        log.fatal("fatal {}", 6);

        System.out.println(new Exception().getStackTrace()[0].getLineNumber());
    }

}