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
	"github.com/citrusframework/yaks/pkg/cmd/operator"
	"github.com/spf13/cobra"
)

func newCmdOperator(rootCmdOptions *RootCmdOptions) *cobra.Command {
	impl := operatorCmdOptions{
		RootCmdOptions: rootCmdOptions,
	}
	cmd := cobra.Command{
		Use:   "operator",
		Short: "Run the Yaks operator",
		Long:  `Run the Yaks operator locally.`,
		Run:   impl.run,
	}

	return &cmd
}

type operatorCmdOptions struct {
	*RootCmdOptions
}

func (o *operatorCmdOptions) run(_ *cobra.Command, _ []string) {
	operator.Run()
}
