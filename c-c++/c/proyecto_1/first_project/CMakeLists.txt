project(cinit)

add_executable(cinit main.c second.c functions/functions.h functions/functions.c)

install(TARGETS cinit RUNTIME DESTINATION bin)
