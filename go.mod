module github.com/citrusframework/yaks

go 1.13

require (
	github.com/Masterminds/semver v1.5.0
	github.com/container-tools/snap v0.0.5
	github.com/coreos/prometheus-operator v0.38.1-0.20200424145508-7e176fda06cc
	github.com/fatih/color v1.9.0
	github.com/gertd/go-pluralize v0.1.7
	github.com/go-logr/logr v0.1.0
	github.com/google/uuid v1.1.1
	github.com/mitchellh/go-homedir v1.1.0
	github.com/mitchellh/mapstructure v1.1.2
	github.com/openshift/api v3.9.1-0.20190927182313-d4a64ec2cbd8+incompatible
	github.com/operator-framework/operator-lifecycle-manager v0.0.0-20200321030439-57b580e57e88
	github.com/operator-framework/operator-sdk v0.17.1
	github.com/pkg/errors v0.9.1
	github.com/rs/xid v1.2.1
	github.com/shurcooL/httpfs v0.0.0-20190707220628-8d4bc4ba7749
	github.com/shurcooL/vfsgen v0.0.0-20181202132449-6a9ea43bcacd
	github.com/sirupsen/logrus v1.5.0
	github.com/spf13/cobra v1.0.0
	github.com/spf13/pflag v1.0.5
	github.com/spf13/viper v1.6.2
	github.com/stoewer/go-strcase v1.0.2
	github.com/stretchr/testify v1.5.1
	github.com/wercker/stern v0.0.0-00010101000000-000000000000
	gopkg.in/yaml.v2 v2.3.0
	k8s.io/api v0.18.2
	k8s.io/apimachinery v0.18.2
	k8s.io/client-go v12.0.0+incompatible
	knative.dev/eventing v0.16.2
	sigs.k8s.io/controller-runtime v0.5.2
)

// Pinned to Kubernetes 0.17.6:
// - Knative 0.16.0 requires  0.17.6
// - Operator SDK 0.17.1 requires 1.17.4
replace (
	github.com/Azure/go-autorest => github.com/Azure/go-autorest v13.3.2+incompatible // Required by OLM
	github.com/mattn/go-sqlite3 => github.com/mattn/go-sqlite3 v1.10.0
	k8s.io/api => k8s.io/api v0.17.6
	k8s.io/apiextensions-apiserver => k8s.io/apiextensions-apiserver v0.17.6
	k8s.io/apimachinery => k8s.io/apimachinery v0.17.6
	k8s.io/apiserver => k8s.io/apiserver v0.17.6
	k8s.io/cli-runtime => k8s.io/cli-runtime v0.17.6
	k8s.io/client-go => k8s.io/client-go v0.17.6
	k8s.io/cloud-provider => k8s.io/cloud-provider v0.17.6
	k8s.io/cluster-bootstrap => k8s.io/cluster-bootstrap v0.17.6
	k8s.io/code-generator => k8s.io/code-generator v0.17.6
	k8s.io/component-base => k8s.io/component-base v0.17.6
	k8s.io/cri-api => k8s.io/cri-api v0.17.6
	k8s.io/csi-translation-lib => k8s.io/csi-translation-lib v0.17.6
	k8s.io/kube-aggregator => k8s.io/kube-aggregator v0.17.6
	k8s.io/kube-controller-manager => k8s.io/kube-controller-manager v0.17.6
	k8s.io/kube-proxy => k8s.io/kube-proxy v0.17.6
	k8s.io/kube-scheduler => k8s.io/kube-scheduler v0.17.6
	k8s.io/kubectl => k8s.io/kubectl v0.17.6
	k8s.io/kubelet => k8s.io/kubelet v0.17.6
	k8s.io/legacy-cloud-providers => k8s.io/legacy-cloud-providers v0.17.6
	k8s.io/metrics => k8s.io/metrics v0.17.6
	k8s.io/sample-apiserver => k8s.io/sample-apiserver v0.17.6
)

replace github.com/wercker/stern => github.com/nicolaferraro/stern v0.0.0-20200115104511-30c4a62d610f

replace github.com/docker/docker => github.com/moby/moby v0.7.3-0.20190826074503-38ab9da00309 // Required by Helm

// Using a fork that removes the https ping before using http in case of insecure registry (for Spectrum)
replace github.com/google/go-containerregistry => github.com/nicolaferraro/go-containerregistry v0.0.0-20200428072705-e7aced86aca8
