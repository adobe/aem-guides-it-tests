# AEM Guides IT Tests

AEM Guides is an Addon on top of AEM on cloud. New releases are pushed to customers automatically without any manual efforts. To ensure a smooth and validated release to customer's environments, AEM Guides team has created a set of tests which can be executed as part of customer upgrade workflows.

## Running these tests as part of customer release pipeline

Add dependency of our tests to in your it.tests module's pom.xml
```
<dependency>
   <groupId>com.adobe.aem.addon.guides</groupId>
   <artifactId>aem-guides-it-tests</artifactId>
   <version>0.0.6</version>
</dependency>
```

Add the below configuration to your maven-failsafe-plugin

```
<dependenciesToScan>
    <dependency>com.adobe.aem.addon.guides:aem-guides-it-tests</dependency>
</dependenciesToScan>
```

Refer the below snippet to figure out where to add the above configuration
```
<execution>
    <id>default-integration-test</id>
    <goals>
        <goal>integration-test</goal>
    </goals>
    <configuration>
        <includes>
            <include>**/*IT.java</include>
        </includes>
        <dependenciesToScan>
            <dependency>com.adobe.aem.addon.guides:aem-guides-it-tests</dependency>
        </dependenciesToScan>
    </configuration>
</execution>
```
## Writing your own tests

Customers can choose to take inspiration from these tests to write their additional tests, in which case the above steps of including the dependeny and adding scan configuration can be skipped.

## How to run tests locally?

```
mvn clean verify -Plocal 
```
