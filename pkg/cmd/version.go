/*
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package cmd

import (
	"fmt"

	"github.com/citrusframework/yaks/pkg/util/defaults"
	"github.com/spf13/cobra"
)

func newCmdVersion(rootCmdOptions *RootCmdOptions) *cobra.Command {
	options := versionCmdOptions{
		RootCmdOptions: rootCmdOptions,
	}

	cmd := cobra.Command{
		PersistentPreRunE: options.preRun,
		Use:               "version",
		Short:             "Return version information",
		RunE:              options.run,
	}

	return &cmd
}

type versionCmdOptions struct {
	*RootCmdOptions
}

func (o *versionCmdOptions) run(cmd *cobra.Command, _ []string) error {
	_, err := fmt.Fprintln(cmd.OutOrStdout(), defaults.Version)
	return err
}
