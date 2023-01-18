# hackathon2301-bo-search-sparque
Replace the default SQL based ICM backoffice search by ... a REST API call --- to Sparque.ai
- [hackathon2301-bo-search-sparque](#hackathon2301-bo-search-sparque)
  - [Introduction](#introduction)
  - [Install](#install)
  - [More Details](#more-details)

## Introduction

a component set icm-sparque-bo with a cartridge ac_bo_search_sparque that implements the ProductBOSearchService to replace the ICM search in the backoffice.

## Install

Prerequisite is an ICM (development) environment above 7.10.32 (used a development environment with ~7.10.40)

- checkout to icm-sparque-bo 
  ```
  git clone git@github.com:intershop/hackathon2301-bo-search-sparque.git icm-sparque-bo
  ```
- build and publish the cartridge
  ```
  gradlew publish
  ```
- include the cartridge into deployment of the assembly e.g. in inspired-b2c/build.gradle
  ```
  include('com.intershop.sparque.bo:ac_bo_search_sparque',
                            in:[development, test, production])
  ```
- add the cartridge to the list
  ```
  order = listFromAssembly('com.intershop.assembly:commerce_management_b2c') + 'ac_bo_search_sparque'
  ```
- add a configuration property to actually use it
  
  The property file can be added globally or to app e.g. in `share/config/apps/intershop.B2CBackoffice` or domain scope e.g. `share/config/domains/inSPIRED-Site`
  ```
  intershop.product.search.serviceID=sparque-bo-search
  ```

## More Details

TODO some more notes about the implementation



