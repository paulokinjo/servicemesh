# Installation

```
$ curl -sL https://run.linkerd.io/install | sh
```

<pre>
Validating checksum...
Checksum valid.

Linkerd stable-2.11.1 was successfully installed 🎉


Add the linkerd CLI to your path with:

  export PATH=$PATH:/home/vagrant/.linkerd2/bin

Now run:

  linkerd check --pre                     # validate that Linkerd can be installed
  linkerd install | kubectl apply -f -    # install the control plane into the 'linkerd' namespace
  linkerd check                           # validate everything worked!
  linkerd dashboard                       # launch the dashboard

Looking for more? Visit https://linkerd.io/2/tasks
</pre>

# Extensions
```
$ linkerd viz install | kubectl apply -f -
```

## Dashboard
```
$ linkerd viz dashboard
```