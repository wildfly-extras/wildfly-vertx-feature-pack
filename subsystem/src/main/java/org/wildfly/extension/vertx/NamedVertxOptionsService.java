/*
 *  Copyright (c) 2022 The original author or authors
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of Apache License v2.0 which
 *  accompanies this distribution.
 *
 *       The Apache License v2.0 is available at
 *       http://www.opensource.org/licenses/apache2.0.php
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package org.wildfly.extension.vertx;

import org.jboss.as.controller.OperationContext;
import org.jboss.msc.service.Service;
import org.jboss.msc.service.ServiceBuilder;
import org.jboss.msc.service.ServiceController;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;

/**
 * @author <a href="mailto:aoingl@gmail.com">Lin Gao</a>
 */
public class NamedVertxOptionsService implements Service<NamedVertxOptions> {

  private final NamedVertxOptions namedVertxOptions;

  NamedVertxOptionsService(NamedVertxOptions namedVertxOptions) {
    this.namedVertxOptions = namedVertxOptions;
  }

  static void installService(OperationContext context, NamedVertxOptions namedVertxOptions) {
    ServiceName vertxServiceName = VertxOptionFileResourceDefinition.VERTX_OPTIONS_CAPABILITY.getCapabilityServiceName(namedVertxOptions.getName());
    ServiceBuilder<?> vertxServiceBuilder = context.getServiceTarget().addService(vertxServiceName);
    vertxServiceBuilder.setInstance(new NamedVertxOptionsService(namedVertxOptions));
    vertxServiceBuilder
      .setInitialMode(ServiceController.Mode.LAZY)
      .install();
  }

  @Override
  public void start(StartContext startContext) throws StartException {
  }

  @Override
  public void stop(StopContext stopContext) {
  }

  @Override
  public NamedVertxOptions getValue() throws IllegalStateException, IllegalArgumentException {
    return namedVertxOptions;
  }

}