# reactive-atdd-workshop

[![Build](https://github.com/juan-zumer/reactive-atdd-workshop/actions/workflows/gradle.yml/badge.svg)](https://github.com/juan-zumer/reactive-atdd-workshop/actions/workflows/gradle.yml)
[![codecov.io](https://codecov.io/gh/juan-zumer/reactive-atdd-workshop/branch/main/graphs/badge.svg)](http://codecov.io/gh/juan-zumer/reactive-atdd-workshop)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=com.thoughtworks:reactive-atdd-workshop&metric=alert_status)](https://sonarcloud.io/dashboard/index/com.thoughtworks:reactive-atdd-workshop)
[![License](https://img.shields.io/badge/License-Apache%202.0-green.svg)](https://opensource.org/licenses/Apache-2.0)

## Description

Reactive ATDD workshop with Spring WebFlux and Cucumber

# Terraform
We use Hashicorp scripts to [create a GKE cluster in GCP](https://learn.hashicorp.com/tutorials/terraform/gke) with some modifications. Requirements:
- Terraform
- GCP account
- Configure gcloud SDK

Request permissions to interact with GCP
```
gcloud init
gcloud auth application-default login
```
Enable GKE services and Container Registry APIs
```
gcloud services enable \
	containerregistry.googleapis.com \
	container.googleapis.com
```
Modify `terraform.tfvars` including the `project_id` and `region` variables and execute:

```
terraform init
terraform apply
```

We included a [GitHub action to deploy the container to GKE](https://docs.github.com/en/actions/guides/deploying-to-google-kubernetes-engine). Before we need to:
- Create a service account with admin roles on container and storage
- Generate the JSON key for the service account

Create a service account
```
$ gcloud iam service-accounts create $SA_NAME
```

Retrieve the email of the service account created
```
$ gcloud iam service-accounts list
```
Assign these permissions for the deployment to happen:

* Kubernetes Engine Admin
* Kubernetes Engine Developer
* Storage Admin

```
$ gcloud projects add-iam-policy-binding $PROJECT_ID \
  --member=serviceAccount:$SA_EMAIL \
  --role=roles/container.admin \
  --role=roles/storage.admin
```
Download the JSON keyfile for the service account
```
$ gcloud iam service-accounts keys create key.json --iam-account=$SA_EMAIL
```
Copy the content of the JSON keyfile and store it in a GitHub secret (GKE_SA_KEY):
```
$ cat key.json | base64
```

And configure two secrets in GitHub:
- `GKE_PROJECT` with the GCP `project_id`
- `GKE_SA_KEY` with the JSON key value
