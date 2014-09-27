# lein new wrom

Webjars + Ring + Om Template.

The goal of this template is to provide a playground for myself to try
out Om snippets.  I use webjars, so that once the React dependency is
downloaded, I can create new projects without having to connect to the
internet. Yes, sometimes I am offline, for example during commutes.

## Features

This template provides:

* [ring](https://github.com/ring-clojure/ring) + jetty for server side code
* [core.async](https://github.com/clojure/core.async)
* [clojurescript](https://github.com/clojure/clojurescript)
* [cljs-http](https://github.com/r0man/cljs-http) for ajax requests
* [Om](https://github.com/swannodette/om) + [React](http://facebook.github.io/react/)
* sample application with:
  - a ring handler on the server that returns a message
  - an Om component that fetches the message from the server and
    renders it

## Usage

To create a new project:

```
lein new wrom foo
```

In one terminal:

````
cd foo
lein cljsbuild auto
````

Changes to Clojurescript (.cljs) code will automatically be compiled
when files change. You will need to refresh the browser to see the
changes.

In another terminal:

````
cd foo
lein ring server
````

A browser window will automatically open. If not, go to
[http://localhost:8090/index.html](http://localhost:8090/index.html).

Changes to Clojure (.clj) code will automatically be compiled upon
browser request.

## License

Copyright Michiel Borkent

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
