# 26fall_java_project_form_nkd

## Contributer: sxz & yyc

# Git & GitHub 双人协作指南

本教程适用于本项目的协作开发，使用 **Git + GitHub + VS Code**。

即使此前完全没用过 Git，也可以按照步骤完成从获取代码到提交、审核、合并代码的全过程。

## 0. 协作工作流总览

我们采用 **Feature Branch + Pull Request** 工作流：

```text
GitHub 远程仓库（main）
       │
       │ git clone / git pull
       ▼
本地 main 分支
       │
       │ git switch -c feature/xxx
       ▼
本地功能分支
       │
       ├── 修改代码
       ├── git add
       ├── git commit
       │
       │ git push
       ▼
GitHub 远程功能分支
       │
       │ Create Pull Request
       ▼
等待另一位开发者 Review
       │
       ├── Request changes → 修改并再次 Push
       │
       └── Approve
               │
               ▼
         Merge into main
               │
               ▼
      双方更新本地 main
```

**协作约定：**

1. `main` 是主分支，应尽量保持代码可运行。
2. 开发新功能时，从最新的 `main` 创建自己的功能分支。
3. 不要直接向 `main` 提交功能代码。
4. 功能完成后，通过 Pull Request（PR）请求合并。
5. 由另一位开发者审核代码，确认无误后合并。
6. 合并后，双方及时同步本地 `main`。

---

## 1. 首次安装与配置

以下以 Windows + VS Code 为例。macOS 用户也可以使用同样的 Git 命令。

### 1.1 安装 Git

打开 Git 官方网站：

https://git-scm.com/install/windows

下载并安装 Git for Windows。

一般使用默认安装配置即可。安装后，可以使用附带的 Git Bash 终端。

打开 VS Code 终端：

`Terminal → New Terminal`

或者使用快捷键：

`Ctrl + Shift + 反引号`

推荐 Windows 用户使用 **Git Bash**。

可以在终端右上角选择 `Select Default Profile → Git Bash`，将 Git Bash 设置为默认终端。

检查安装：

```bash
git --version
```

成功时会输出类似：

```text
git version 2.x.x
```

本项目是纯 Java 项目，**不要求安装 WSL**。

### 1.2 配置 Git 用户信息

首次安装 Git，需要设置提交记录中使用的姓名和邮箱。

```bash
git config --global user.name "YourName"
git config --global user.email "your_email@example.com"
```

将上述姓名和邮箱替换为自己的信息。邮箱可以使用 GitHub 配置的邮箱，或 GitHub 提供的隐私保护邮箱。

检查设置：

```bash
git config --global --list
```

注意：Git 提交信息与 GitHub 登录认证是两回事，这一步不会自动登录 GitHub。

### 1.3 接受 GitHub 仓库邀请

首先注册并登录 GitHub：

https://github.com/

仓库管理员需要邀请你加入项目：

`Repository → Settings → Collaborators → Add people`

输入你的 GitHub 用户名，发送邀请。

**被邀请人需要接受邀请，才能获得相应的仓库协作权限。**

接受成功后，可以直接在原仓库创建和推送功能分支，不需要 Fork。

---

## 2. 克隆仓库到本地

`Clone` 的作用是把 GitHub 上的远程仓库完整复制到本地电脑。

### Step 1：获取仓库地址

进入 GitHub 项目主页，点击：

`Code → HTTPS → Copy URL`

复制仓库链接。

### Step 2：Clone

打开 Git Bash 或 VS Code 终端，进入准备存放项目的目录。

例如：

```bash
mkdir -p ~/Projects
cd ~/Projects
```

运行：

```bash
git clone https://github.com/Sxxz223/26fall_Final_project.git
```

注意：仓库地址以 GitHub 页面 `Code` 按钮中复制的实际地址为准。

进入仓库目录：

```bash
cd 26fall_Final_project
```

### Step 3：检查远程仓库连接

```bash
git remote -v
```

预期会看到：

```text
origin  https://github.com/Sxxz223/26fall_Final_project.git (fetch)
origin  https://github.com/Sxxz223/26fall_Final_project.git (push)
```

`origin` 是 Git 自动设置的远程仓库别名。

**使用 `git clone` 后，远程连接已经建立，不需要再执行 `git remote add origin`。**

### Step 4：使用 VS Code 打开项目

```bash
code .
```

如果 `code` 命令不可用，可以直接使用 VS Code 的 `File → Open Folder` 打开克隆得到的项目文件夹。

---

## 3. 创建分支并开发

重要：**每次准备开发新功能，都应该从最新的 `main` 创建分支。**

### Step 1：切换到 main

```bash
git switch main
```

### Step 2：同步最新代码

```bash
git pull origin main
```

这一步会从 GitHub 下载并合并主分支的最新修改。

建议在本地 `main` 没有未提交修改时执行。

### Step 3：创建功能分支

例如，要开发象棋棋子的移动逻辑：

```bash
git switch -c feature/piece-movement
```

其中：

- `switch`：切换分支。
- `-c`：创建新分支并立即切换。
- `feature/piece-movement`：分支名称。

推荐命名方式：

| 类型 | 示例 |
|---|---|
| 新功能 | `feature/piece-movement` |
| Bug 修复 | `fix/invalid-move` |
| 文档更新 | `docs/update-readme` |
| 工作流测试 | `test/workflow-alice` |

查看当前分支：

```bash
git branch
```

例如：

```text
* feature/piece-movement
  main
```

星号 `*` 表示当前所在分支。

**之后所有代码修改都应该发生在自己的功能分支中。**

---

## 4. 提交代码

完成一部分代码后，需要将修改记录到 Git。

### Step 1：检查修改

```bash
git status
```

查看具体修改：

```bash
git diff
```

### Step 2：暂存修改

如果需要提交当前目录下的所有新增、修改和删除内容：

```bash
git add .
```

如果只需要提交某个文件：

```bash
git add README.md
```

检查暂存状态：

```bash
git status
```

### Step 3：Commit

```bash
git commit -m "feat: implement piece movement"
```

`commit` 表示把暂存的修改保存为一次本地版本记录。

推荐提交信息格式：

| 前缀 | 含义 |
|---|---|
| `feat:` | 新功能 |
| `fix:` | 修复 Bug |
| `docs:` | 文档修改 |
| `refactor:` | 重构代码 |
| `test:` | 测试相关 |
| `chore:` | 其他维护操作 |

例如：

```bash
git commit -m "fix: prevent illegal moves"
```

### Step 4：Push 到 GitHub

首次推送新分支：

```bash
git push -u origin feature/piece-movement
```

这里的 `-u` 会建立本地分支与对应远程分支的跟踪关系。

以后在这个分支上再次提交，可以直接运行：

```bash
git push
```

注意三个概念：

- `git add`：将修改放入暂存区。
- `git commit`：把暂存内容保存为本地提交。
- `git push`：将本地提交推送到远程仓库。

**Commit 不等于 Push。只有 Push 之后，其他人才可以在 GitHub 上看到你的提交。**

首次 Push 可能要求 GitHub 登录认证。按照浏览器或 Git Credential Manager 的提示登录即可，不需要把 GitHub 账号密码发给其他人。

---

## 5. 创建 Pull Request

Push 完成后，打开 GitHub 仓库。

通常会看到：

`Compare & pull request`

点击进入 PR 创建页面。

如果没有出现提示，也可以手动进入：

`Pull requests → New pull request`

### Step 1：确认分支方向

```text
base: main
compare: feature/piece-movement
```

表示：

把 `feature/piece-movement` 分支的修改，请求合并进入 `main`。

**注意不要把 base 和 compare 选反。**

### Step 2：填写 PR 信息

标题示例：

```text
feat: implement piece movement
```

描述示例：

```markdown
## Changes
- Implemented basic piece movement
- Added board boundary checks
- Fixed invalid move handling

## Testing
- [x] Project compiles
- [x] Basic movement tested
- [ ] Full game logic tested
```

### Step 3：创建 PR

点击：

`Create pull request`

创建成功后，进入 PR 详情页面。

PR 此时处于 `Open` 状态，表示等待处理，**并不意味着代码已经合并**。

### Step 4：邀请另一位开发者审核

在 PR 页面右侧找到：

`Reviewers`

选择另一位开发者，让对方负责审核。

然后通知对方查看 PR。

---

## 6. 审核别人的 PR（Review）

这是双人协作中非常重要的一步。

例如：

- 开发者 A 完成棋子移动功能，创建 PR。
- 开发者 B 检查代码，给出意见。
- A 根据意见修改。
- B 确认通过。
- 最后合并到 `main`。

### Step 1：进入 PR 页面

打开 GitHub 仓库：

`Pull requests → 选择待审核 PR`

进入 PR 后，主要会看到：

| 页面 | 作用 |
|---|---|
| Conversation | 查看 PR 讨论、审核记录与合并状态 |
| Commits | 查看该 PR 包含的提交 |
| Files changed | 查看具体代码修改 |
| Checks | 查看自动化检查结果（如果已配置） |

### Step 2：检查代码

点击：

`Files changed`

GitHub 会显示代码差异：

- 绿色：新增内容。
- 红色：删除内容。

审核时建议关注：

1. 修改是否符合功能需求。
2. 代码逻辑是否正确。
3. 是否影响其他已有功能。
4. 是否有明显的 Bug。
5. 项目是否还能编译和运行。

如果需要对某一行提出意见，可以将鼠标移动到对应行，点击旁边的 `+` 添加评论。

### Step 3：提交 Review

点击 `Review changes`。

通常可以选择以下三种审核结果：

**Comment**

只发表评论，不明确批准或要求修改。

**Approve**

表示审核通过，认可该 PR 可以合并。

**Request changes**

表示发现需要修改的问题，希望作者修正后再次审核。

选择后点击：

`Submit review`

注意：提出修改请求是否会强制阻止合并，取决于仓库的分支保护规则。没有相应规则时，Review 更多是一种协作约定。

此外，GitHub 不允许 PR 作者批准自己的 PR。

### Step 4：如果被要求修改代码

PR 作者回到自己的本地功能分支：

```bash
git switch feature/piece-movement
```

根据 Reviewer 的意见修改代码。

然后重新提交：

```bash
git add .
git commit -m "fix: address review feedback"
git push
```

**不需要重新创建 PR。**

新的 Commit Push 到对应分支后，原来的 PR 会自动更新。

Reviewer 可以再次检查，然后提交 `Approve`。

---

## 7. 合并 PR

审核通过后，进入 PR 的 `Conversation` 页面。

确认：

- 功能实现正确。
- 没有需要继续处理的 Review 意见。
- 没有未解决的合并冲突。
- 满足仓库配置的合并要求。

点击：

`Merge pull request`

然后点击：

`Confirm merge`

成功后，PR 会显示 `Merged` 状态。

此时远程仓库的 `main` 已经包含该功能。

对于本项目，建议由 Reviewer 在审核通过后执行 Merge，减少误操作。实际能否合并仍取决于账号权限及仓库规则。

### 删除远程功能分支

合并成功后，GitHub 通常会提供：

`Delete branch`

如果该分支不再需要，可以删除它。

删除已经合并的功能分支不会删除进入 `main` 的代码。

---

## 8. 合并后同步本地代码

非常重要：

**GitHub 上的 main 更新，不代表本地 main 自动更新。**

每位开发者都应该执行：

```bash
git switch main
git pull origin main
```

如果本地测试分支已经合并，可以删除：

```bash
git branch -d feature/piece-movement
```

这样，下一次开发就可以从最新的 `main` 重新创建功能分支。

不要长期在旧分支上连续开发多个无关功能。

---

## 9. 双人 Git 工作流实战测试

在正式开发象棋项目之前，建议两个人完整测试一轮 Git 协作流程。

为了避免影响业务代码，测试只添加简单的文本文件。

### Round 1：开发者 A 提交，开发者 B 审核

**开发者 A：创建测试分支**

```bash
git switch main
git pull origin main
git switch -c test/workflow-a
```

创建一个测试文件（在 Git Bash 中运行）：

```bash
mkdir -p collab-test
echo "Hello from developer A" > collab-test/developer-a.txt
```

提交修改：

```bash
git add collab-test/developer-a.txt
git commit -m "test: verify workflow A"
git push -u origin test/workflow-a
```

进入 GitHub，创建 PR：

```text
base: main
compare: test/workflow-a
```

指定开发者 B 为 Reviewer。

**开发者 B：审核**

1. 打开 GitHub 项目。
2. 进入 `Pull requests`。
3. 选择 A 创建的 PR。
4. 点击 `Files changed`。
5. 检查 `developer-a.txt` 内容。
6. 点击 `Review changes`。
7. 选择 `Approve`。
8. 点击 `Submit review`。
9. 按团队约定合并该 PR。

**双方：同步 main**

```bash
git switch main
git pull origin main
```

查看项目中的 `collab-test/developer-a.txt`，确认 A 的修改已经进入主分支。

### Round 2：开发者 B 提交，开发者 A 审核

交换角色。

**开发者 B：**

```bash
git switch main
git pull origin main
git switch -c test/workflow-b
```

创建测试文件：

```bash
mkdir -p collab-test
echo "Hello from developer B" > collab-test/developer-b.txt
```

提交并推送：

```bash
git add collab-test/developer-b.txt
git commit -m "test: verify workflow B"
git push -u origin test/workflow-b
```

在 GitHub 创建 PR：

```text
base: main
compare: test/workflow-b
```

指定开发者 A 为 Reviewer。

**开发者 A：**

1. 查看 B 的 PR。
2. 进入 `Files changed`。
3. 检查修改内容。
4. 选择 `Approve` 并提交 Review。
5. 按团队约定合并 PR。

合并完成后，双方运行：

```bash
git switch main
git pull origin main
```

检查：

```bash
ls collab-test
```

预期能看到：

```text
developer-a.txt
developer-b.txt
```

两个测试文件都成功合并到 `main`，说明双方已经完成了一次完整的双向协作测试。

测试结束后，可以再通过一个 `chore` 分支和 PR 删除测试文件，保持项目整洁。

---

## 10. 日常开发常用命令速查

| 命令 | 作用 |
|---|---|
| `git status` | 查看仓库状态 |
| `git branch` | 查看本地分支 |
| `git branch -a` | 查看本地和远程分支 |
| `git switch main` | 切换到 main |
| `git pull origin main` | 更新本地 main |
| `git switch -c feature/xxx` | 创建并切换功能分支 |
| `git diff` | 查看尚未暂存的修改 |
| `git add .` | 暂存当前目录中的修改 |
| `git commit -m "message"` | 创建提交 |
| `git push` | 推送到已关联的远程分支 |
| `git log --oneline -5` | 查看最近五次提交 |
| `git remote -v` | 查看远程仓库连接 |
| `git branch -d branch-name` | 删除已合并的本地分支 |

### 日常工作流最简版

每次开始新任务：

```bash
git switch main
git pull origin main
git switch -c feature/my-task
```

开发结束：

```bash
git status
git add .
git commit -m "feat: describe your changes"
git push -u origin feature/my-task
```

然后在 GitHub 创建 PR，邀请对方 Review。

合并结束：

```bash
git switch main
git pull origin main
```

---

## 11. 常见问题

### Q1：Clone 后还要创建远程连接吗？

不需要。

`git clone` 会自动配置 `origin`。只有自行通过 `git init` 初始化本地仓库、且尚未配置远程仓库时，才通常需要使用 `git remote add origin`。

### Q2：为什么 Push 被拒绝？

可能原因包括：

- 没有接受 GitHub 仓库邀请。
- 登录认证失败。
- 当前账号没有写入权限。
- 远程同名分支已经有本地尚未获取的新提交。
- 仓库规则限制了 Push。

先检查：

```bash
git status
git remote -v
```

不要为了绕过错误直接使用 `git push --force`。

### Q3：修改了代码，但切换不了分支？

可能存在未提交的修改。

运行：

```bash
git status
```

确认修改后，可以选择 Commit，或者暂存当前工作：

```bash
git stash
```

在合适的分支恢复：

```bash
git stash pop
```

使用 `stash` 前应清楚当前修改属于哪个任务，避免恢复到错误分支。

### Q4：PR 出现 Merge conflict 怎么办？

说明两个分支修改了彼此冲突的内容，需要手动解决。

不要随意覆盖对方的代码。

建议先与另一位开发者确认冲突部分，再通过 VS Code 的冲突解决工具处理。

### Q5：每次修改代码都要新建 PR 吗？

不需要。

一个功能分支可以有多个 Commit。

只要 PR 尚未合并，继续向该分支 Push，原 PR 就会自动更新。

一个功能开发完成后，通常只需要一个 PR。

### Q6：为什么我看不到 Approve 选项？

可能原因包括你正在审核自己创建的 PR、权限不足或 GitHub 界面状态不同。

**PR 作者不能批准自己的 PR。**

请使用另一位协作者的 GitHub 账号审核。

### Q7：可以直接在 main 修改代码吗？

Git 本身允许在没有限制的分支上提交修改，但本项目约定：

**正常开发不直接向 main 提交代码，统一通过 PR 合并。**

这样更容易追踪代码来源、检查修改、发现问题和回退错误提交。

---

## 12. 项目协作约定

为保证两人开发效率，约定如下：

- 开始新任务之前，先同步最新的 `main`。
- 不同功能尽量使用不同分支。
- 不要在同一个工作目录中反复切换分支时遗漏未提交修改。
- PR 尽量只解决一个明确的问题。
- 不提交编译产物、临时文件、密码或私人配置。
- PR 创建后，邀请另一位开发者 Review。
- Reviewer 不只是点击 Approve，还应该检查逻辑、编译和关键功能。
- 修改完成后及时同步主分支。

**最终目标：每一项功能都能明确知道是谁开发、修改了什么、由谁审核、何时合并。**

## 参考资料

- [Git 官方网站](https://git-scm.com/)
- [GitHub：Cloning a repository](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository)
- [GitHub：Creating a pull request](https://docs.github.com/en/pull-requests/how-tos/create-pull-requests/creating-a-pull-request)
- [GitHub：Reviewing proposed changes](https://docs.github.com/en/pull-requests/how-tos/review-pull-requests/reviewing-proposed-changes-in-a-pull-request)

    
