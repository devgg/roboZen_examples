SUBDIRS = . addrtest udpsockettest tcpsockettest iosocketstreamtest 

lib_LTLIBRARIES = librcssnet.la

CLEANFILES = \
*~ \
core \
install_files

librcssnet_la_SOURCES = \
addr.hpp \
addr.cpp \
socket.hpp \
socket.cpp \
udpsocket.hpp \
udpsocket.cpp \
tcpsocket.hpp \
tcpsocket.cpp \
handler.hpp \
handler.cpp

AM_CXXFLAGS = -Wall -I$(top_srcdir)
AM_LDFLAGS = -L../error

librcssnet_la_LDFLAGS = -version-info 1:0:0 -L../error
#    1. Start with version information of `0:0:0' for each libtool library.
# 
#    2. Update the version information only immediately before a public
#       release of your software.  More frequent updates are unnecessary,
#       and only guarantee that the current interface number gets larger
#       faster.
# 
#    3. If the library source code has changed at all since the last
#       update, then increment REVISION (`C:R:A' becomes `C:r+1:A').
# 
#    4. If any interfaces have been added, removed, or changed since the
#       last update, increment CURRENT, and set REVISION to 0.
# 
#    5. If any interfaces have been added since the last public release,
#       then increment AGE.
# 
#    6. If any interfaces have been removed since the last public release,
#       then set AGE to 0.

librcssnet_la_LIBADD = @NET_LIBS@ -lrcsserror

netdir = $(pkgincludedir)/net

net_HEADERS = \
addr.hpp \
socket.hpp \
udpsocket.hpp \
tcpsocket.hpp \
socketstreambuf.hpp \
isocketstream.hpp \
osocketstream.hpp \
iosocketstream.hpp \
handler.hpp 

EXTRA_DIST = ac_lib_rcssnet.m4 SConscript

pkgdata_DATA = ac_lib_rcssnet.m4


@INCLUDE_MK@
