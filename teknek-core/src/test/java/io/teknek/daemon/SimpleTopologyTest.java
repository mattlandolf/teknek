/*
Copyright 2013 Edward Capriolo, Matt Landolf, Lodwin Cueto

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package io.teknek.daemon;

import java.util.HashMap;
import java.util.Map;

import org.apache.zookeeper.ZooKeeper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import io.teknek.driver.Minus1Operator;
import io.teknek.driver.Times2Operator;
import io.teknek.feed.FixedFeed;
import io.teknek.kafka.EmbeddedKafkaServer;
import io.teknek.plan.FeedDesc;
import io.teknek.plan.OperatorDesc;
import io.teknek.plan.Plan;
import io.teknek.util.MapBuilder;

public class SimpleTopologyTest extends EmbeddedKafkaServer{

static TechniqueDaemon td = null;
  
  @BeforeClass
  public static void setup(){
    Map<String,String> props = new HashMap<String,String>();
    props.put(TechniqueDaemon.ZK_SERVER_LIST, zookeeperTestServer.getConnectString());
    td = new TechniqueDaemon(props);
    td.init();
  }
  
  @Test
  public void hangAround(){
    Plan p = new Plan().withFeedDesc(
            new FeedDesc().withFeedClass(FixedFeed.class.getName()).withProperties(
                    MapBuilder.makeMap(FixedFeed.NUMBER_OF_PARTITIONS, 2, FixedFeed.NUMBER_OF_ROWS,
                            10))).withRootOperator(
            new OperatorDesc(new BeLoudOperator()));
    p.setName("yell");
    p.setMaxWorkers(1);
    td.applyPlan(p);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  @AfterClass
  public static void shutdown(){
    td.stop();
  }
}
