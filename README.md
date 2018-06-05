# nettyClient




### 1.2-SNAPSHOT(branch-channelPool)
Using the FixedChannelPool to control the max-connetion to a server.

But there is some problems in channelPool.acquire() method - channels are always been created, channelAcquired() method is never called. Maybe because in this project a channel will be locked by countDownLatch until it receive the http response, and then this channel will be closed, so channel is never reused in this case. The connetionPool is only used to control the max number of connections.

